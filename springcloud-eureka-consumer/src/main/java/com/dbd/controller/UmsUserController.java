package com.dbd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbd.common.api.ApiResult;
import com.dbd.model.dto.LoginDTO;
import com.dbd.model.dto.RegisterDTO;
import com.dbd.model.entity.KillerRate;
import com.dbd.model.entity.Rate;
import com.dbd.model.entity.User;
import com.dbd.service.KillerRateService;
import com.dbd.service.RateService;
import com.dbd.service.UmsUserService;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.dbd.jwt.JwtUtil.USER_NAME;

@CrossOrigin
@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController {
    @Resource
    private UmsUserService umsUserService;

    @Resource
    private RateService rateService;

    @Resource
    private KillerRateService killerRateService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String,Object>> register(@Valid @RequestBody RegisterDTO dto){
        User user = umsUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = umsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<User> getUser(@RequestHeader(value = USER_NAME) String userName) {
        User user = umsUserService.getUserByUsername(userName);
        return ApiResult.success(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "注销成功");
    }

    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        User user = umsUserService.getUserByUsername(username);
        Assert.notNull(user, "用户不存在");
        Page<Rate> page1 = rateService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<Rate>().eq(Rate::getUserId, user.getId()));
        Page<KillerRate> page2 = killerRateService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<KillerRate>().eq(KillerRate::getUserId, user.getId()));
        map.put("survivor",page1);
        map.put("killer",page2);
        map.put("user",user);
        return ApiResult.success(map);
    }
    @PostMapping("/update")
    public ApiResult<User> updateUser(@RequestBody User user) {
        umsUserService.updateById(user);
        return ApiResult.success(user);
    }
}
