package com.dbd.quartz.action;


import gecco.exec.Sacred;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SacredJob extends QuartzJobBean {
//    @Autowired
//    public SacredJob(Sacred sacred){
//        this.sacred = sacred;
//    }

    private Sacred sacred = new Sacred();
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()) + "更新了神秘圣所");// new Date()为获取当前系统时间
        sacred.run();
    }
}
