package com.answer.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liufeng
 * 2021/11/29 15:18
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(){
        //topic类型
        rabbitTemplate.convertAndSend("exchange", "topic.message", "21dafa");
        return "success";
    }
}
