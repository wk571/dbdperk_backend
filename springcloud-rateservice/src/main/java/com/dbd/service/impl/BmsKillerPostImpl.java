package com.dbd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.BmsKillerTopicMapper;

import com.dbd.model.entity.KillerPost;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Tag;
import com.dbd.model.entity.TopicTag;
import com.dbd.model.vo.PostVO;
import com.dbd.service.BmsKillerPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BmsKillerPostImpl extends ServiceImpl<BmsKillerTopicMapper, KillerPost> implements BmsKillerPostService {

//    @Resource
//    private BmsTagMapper bmsTagMapper;
//    @Resource
//    private UmsUserMapper umsUserMapper;
//
//    @Autowired
////    @Lazy
//    private BmsTagService bmsTagService;
//
//    @Autowired
//    private UmsUserService umsUserService;
//
//    @Autowired
//    private com.dbd.service.BmsTopicTagService bmsTopicTagService;
    @Override
//    public Page<PostVO> getList(Page<PostVO> page, String tab) {
//        //判断要查询的是屠夫技能还是逃生者技能
//        Page<PostVO> iPage;
//        //这里找错误找了好久，原来是因为String的对比要用equal
//        iPage = this.baseMapper.selectListAndPage(page, tab);
//
//        // 查询话题
//        // 查询话题的标签
//        setTopicTags(iPage);
//        return iPage;
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Post create(CreateTopicDTO dto, User user) {
//        Post topic1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getTitle, dto.getTitle()));
//        Assert.isNull(topic1, "话题已存在，请修改");

    // 封装
//        Post topic = Post.builder()
//                .userId(user.getId())
//                .title(dto.getTitle())
//                .content(EmojiParser.parseToAliases(dto.getContent()))
//                .createTime(new Date())
//                .build();
//        this.baseMapper.insert(topic);

    // 用户积分增加
//        int newScore = user.getScore() + 1;
//        umsUserMapper.updateById(user.setScore(newScore));

    // 标签
//        if (!ObjectUtils.isEmpty(dto.getTags())) {
//            // 保存标签
//            List<Tag> tags = bmsTagService.insertTags(dto.getTags());
//            // 处理标签与话题的关联
//            bmsTopicTagService.createTopicTag(topic.getId(), tags);
//        }
//
//        return topic;
//    }

//    @Override
//    public Map<String, Object> viewTopic(String id) {
//        Map<String, Object> map = new HashMap<>(16);
//        KillerPost topic = this.baseMapper.selectById(id);
//        Assert.notNull(topic, "当前话题不存在,或已被作者删除");
//        // 查询话题详情
//        topic.setView(topic.getView() + 1);
//        this.baseMapper.updateById(topic);
//        // emoji转码
//        topic.setContent(EmojiParser.parseToUnicode(topic.getContent()));
//        map.put("topic", topic);
//        // 标签
//        QueryWrapper<TopicTag> wrapper = new QueryWrapper<>();
//        wrapper.lambda().eq(TopicTag::getTopicId, topic.getId());
//        Set<String> set = new HashSet<>();
//        for (TopicTag articleTag : bmsTopicTagService.list(wrapper)) {
//            set.add(articleTag.getTagId());
//        }
//        List<Tag> tags = null;
//        if(!set.isEmpty()) tags = bmsTagService.listByIds(set);
//        map.put("tags", tags);

        // 作者

//        ProfileVO user = umsUserService.getUserProfile(topic.getUserId());
//        map.put("user", user);
//
//        return map;
//    }

//    @Override
//    public List<Post> getRecommend(String id) {
//        return this.baseMapper.selectRecommend(id);
//    }
//    /*
//    为什么这里的BaseMapper是BmsTopicMapper的？
//    因为翻到最上面，这个Impl继承的IService<BmsTopicMapper,BmsPost>，所以baseMapper是BmsTopicMapper的
//     */
//    @Override
//    public Page<PostVO> searchByKey(String keyword, Page<PostVO> page) {
//        // 查询话题
//        Page<PostVO> iPage = this.baseMapper.searchByKey(page, keyword);
//        // 查询话题的标签
//        setTopicTags(iPage);
//        return iPage;
//    }

//    private void setTopicTags(Page<PostVO> iPage) {
//        iPage.getRecords().forEach(topic -> {
//            List<TopicTag> topicTags = bmsTopicTagService.selectByTopicId(topic.getId());
//            if (!topicTags.isEmpty()) {
//                List<String> tagIds = topicTags.stream().map(TopicTag::getTagId).collect(Collectors.toList());
//                List<Tag> tags = bmsTagMapper.selectBatchIds(tagIds);
//                topic.setTags(tags);
//            }
//        });
//    }

    public Map<String,Object> ratePerk(String id,int appearance,int popularity){
        KillerPost perk = this.baseMapper.selectById(id);
        perk.setAppearpeople((perk.getAppearpeople() == null ? 0 : perk.getAppearpeople()) + 1);
        perk.setAppearance((perk.getAppearance() == null ? 0 : perk.getAppearance()) + appearance);
        perk.setPoppeople((perk.getPoppeople() == null ? 0 : perk.getPoppeople()) + 1);
        perk.setPopularity((perk.getPopularity() == null ? 0 :perk.getPopularity())+ popularity);
        this.baseMapper.updateById(perk);
        Map<String,Object> map = new HashMap<>(16);
        map.put("topic",perk);
        return map;
    }

    public Map<String,Object> unratePerk(String id,int appearance,int popularity){
        KillerPost perk = this.baseMapper.selectById(id);
        perk.setAppearpeople((perk.getAppearpeople() == null ? 0 : perk.getAppearpeople()) - 1);
        perk.setAppearance((perk.getAppearance() == null ? 0 : perk.getAppearance()) - appearance);
        perk.setPoppeople((perk.getPoppeople() == null ? 0 : perk.getPoppeople()) - 1);
        perk.setPopularity((perk.getPopularity() == null ? 0 :perk.getPopularity()) - popularity);
        this.baseMapper.updateById(perk);
        Map<String,Object> map = new HashMap<>(16);
        map.put("topic",perk);
        return map;
    }
}
