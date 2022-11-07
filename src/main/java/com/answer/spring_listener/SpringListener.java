package com.answer.spring_listener;

import com.answer.service.ValueAnnotateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * created by liufeng
 * 2019/4/23
 */
@Component
public class SpringListener implements ApplicationListener<SpringEvent> {
    @Value("${answer.name}")
    private String name;

    @Autowired
    private ValueAnnotateService valueAnnotateService;

    @Override
    public void onApplicationEvent(SpringEvent springEvent) {
        System.out.println("监听到消息：" + springEvent.getMessage() + name);
        try {
            valueAnnotateService.systemValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
