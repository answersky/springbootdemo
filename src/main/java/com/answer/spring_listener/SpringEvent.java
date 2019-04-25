package com.answer.spring_listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * created by liufeng
 * 2019/4/23
 */
public class SpringEvent extends ApplicationContextEvent {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public SpringEvent(ApplicationContext source,String message) {
        super(source);
        this.message=message;
    }
}
