package com.answer;

import com.answer.config.DynamicProperties;
import com.answer.service.AscpectTestService;
import com.answer.signin.IDoSignService;
import com.answer.spring_listener.SpringEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

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

    @Autowired
    private IDoSignService doSignService;
    @Autowired
    private JedisPool jedisPool;


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

        //测试redis bitmap实现签到
        testRedisBitMapSign();

    }

    private void testRedisBitMapSign() {
        LocalDate today=LocalDate.of(2020,12,2);
        Jedis jedis=jedisPool.getResource();
        { // doSign
            boolean signed = doSignService.doSignIn(jedis,1000, today);
            if (signed) {
                System.out.println("您已签到：" + formatDate(today, "yyyy-MM-dd"));
            } else {
                System.out.println("签到完成：" + formatDate(today, "yyyy-MM-dd"));
            }
        }

        { // checkSign
            boolean signed = doSignService.checkSign(jedis,1000, today);
            if (signed) {
                System.out.println("您已签到：" + formatDate(today, "yyyy-MM-dd"));
            } else {
                System.out.println("尚未签到：" + formatDate(today, "yyyy-MM-dd"));
            }
        }

        { // getSignCount
            long count = doSignService.getSignCount(jedis,1000, today);
            System.out.println("本月签到次数：" + count);
        }

        { // getContinuousSignCount
            long count = doSignService.getContinuousSignCount(jedis,1000, today);
            System.out.println("连续签到次数：" + count);
        }

        { // getFirstSignDate
            LocalDate date = doSignService.getFirstSignDate(jedis,1000, today);
            System.out.println("本月首次签到：" + formatDate(date, "yyyy-MM-dd"));
        }

        { // getSignInfo
            System.out.println("当月签到情况：");
            Map<String, Boolean> signInfo = new TreeMap<>(doSignService.getSignInfo(jedis,1000, today));
            for (Map.Entry<String, Boolean> entry : signInfo.entrySet()) {
                System.out.println(entry.getKey() + ": " + (entry.getValue() ? "√" : "-"));
            }
        }
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
