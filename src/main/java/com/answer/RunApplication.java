package com.answer;

import com.answer.config.DynamicProperties;
import com.answer.service.AscpectTestService;
import com.answer.spring_listener.SpringEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * created by liufeng
 * 2018/8/21
 */
@Configuration
@SpringBootApplication
@EnableScheduling
//开启切面
@EnableAspectJAutoProxy
public class RunApplication implements ApplicationRunner {
    private static final Logger log=LoggerFactory.getLogger(RunApplication.class);

    @Autowired
    private DynamicProperties dynamicProperties;

    @Autowired
    private AscpectTestService ascpectTestService;


    public static void main(String[] args) {
//        SpringApplication.run(RunApplication.class,args);
        SpringApplication application = new SpringApplication(RunApplication.class);

        ConfigurableApplicationContext context = application.run(args);
        //注册自定义监听事件
        SpringEvent springEvent=new SpringEvent(context,"Spring事件");
        context.publishEvent(springEvent);
        log.error("logback日志打印");

    }

    /**
     * springboot启动时自动执行方法
     * @param applicationArguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments applicationArguments){
        log.error("run method execute!!!");
//        dynamicProperties.initConfig();

        try {
            ascpectTestService.getException(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
