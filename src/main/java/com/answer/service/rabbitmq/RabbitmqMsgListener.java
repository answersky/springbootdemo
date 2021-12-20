package com.answer.service.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author liufeng
 * 2021/11/29 15:30
 */
@Service
public class RabbitmqMsgListener {

    int count  = 0;

    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void dealMsg(Message message, Channel channel) throws IOException {
        System.out.println(message);
        int b = 1/0;
    }
}
