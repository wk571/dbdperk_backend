package com.gecco.entity;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.gecco.exec.MainPage;
import com.gecco.mapper.PerkMapper;
import com.gecco.pojo.Perk;
import com.gecco.utils.MyBatisUtil;
import com.gecco.utils.PatternUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@PipelineName(value="perkPipeline")
public class PerkPipeline implements Pipeline<MainPage> {

    public void process(MainPage mainPage) {
        List<String> descriptions = mainPage.getDescriptions();
        List<String> titles = mainPage.getTitles();
        List<String> images = mainPage.getImages();
        List<String> resources = mainPage.getResources();
        SqlSession sqlSession = MyBatisUtil.openSession();
        for (int i = 0;i < descriptions.size();i ++){
            PerkMapper perkMapper = sqlSession.getMapper(PerkMapper.class);
            perkMapper.insert(new Perk(
                    PatternUtil.delete(titles.get(i)),
                    PatternUtil.deleteForResource(resources.get(i)),
                    PatternUtil.delete(descriptions.get(i)),
                    PatternUtil.delete(images.get(i))
            ));
            if(i % 20 == 0) sqlSession.commit();
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
