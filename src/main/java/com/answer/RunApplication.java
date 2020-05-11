package com.answer;

import com.answer.spring_listener.SpringEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * created by liufeng
 * 2018/8/21
 */
@Configuration
@SpringBootApplication
public class RunApplication {
    private static final Logger log=LoggerFactory.getLogger(RunApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(RunApplication.class,args);
        SpringApplication application = new SpringApplication(RunApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        SpringEvent springEvent=new SpringEvent(context,"Spring事件");
        context.publishEvent(springEvent);
        log.error("logback日志打印");
    }
}
