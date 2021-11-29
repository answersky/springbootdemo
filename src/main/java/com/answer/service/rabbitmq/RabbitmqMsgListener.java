package com.answer.service.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Service;

/**
 * @author liufeng
 * 2021/11/29 15:30
 */
@Service
public class RabbitmqMsgListener {

    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void dealMsg(Integer data,Message message){
        try {
            System.out.println(message);
            System.out.println(data);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
