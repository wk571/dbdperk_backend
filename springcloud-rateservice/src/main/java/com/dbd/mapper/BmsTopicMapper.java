package com.dbd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbd.model.entity.Post;
import com.dbd.model.vo.PostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BmsTopicMapper extends BaseMapper<Post> {
    /**
     * 分页查询首页话题列表
     * <p>
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> selectListAndPage(@Param("page") Page<PostVO> page, @Param("tab") String tab);
    Page<PostVO> selectListAndPageKiller(@Param("page") Page<PostVO> page, @Param("tab") String tab);
    /**
     * 获取详情页推荐
     *
     * @param id
     * @return
     */
    List<Post> selectRecommend(@Param("id") String id);
    /**
     * 全文检索
     *
     * @param page
     * @param keyword
     * @return
     */
    Page<PostVO> searchByKey(@Param("page") Page<PostVO> page, @Param("keyword") String keyword);

    Post selectKillerTitle(@Param("title") String title);
}
