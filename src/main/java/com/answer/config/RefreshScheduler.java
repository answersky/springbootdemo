package com.answer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2020/7/14
 * 定时检查更新配置
 */
@Component
public class RefreshScheduler {
    private static final Logger log=LoggerFactory.getLogger(RefreshScheduler.class);
    @Autowired
    private DynamicProperties dynamicProperties;

    @Scheduled(cron = "*/5 * * * * ?")
    public void scheduling() {
        log.error("定时检查更新配置任务执行.......");
        /* Spring的环境中定时刷新 */
        dynamicProperties.initConfig();
    }
}
