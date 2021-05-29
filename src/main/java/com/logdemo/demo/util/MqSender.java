package com.logdemo.demo.util;

import com.logdemo.demo.config.MqConfig;
import org.springframework.amqp.AmqpIllegalStateException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object msg){




//        rabbitTemplate.convertAndSend(msg,MqConfig.QUEUENAME);
//        String send = msg.toString();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend(MqConfig.QUEUENAME, msg);
/*        Message message = convertMessageIfNecessary(msg);
        String consumerQueue = message.getMessageProperties().getConsumerQueue();
        System.out.println(consumerQueue);*/
        /*rabbitTemplate.send(convertMessageIfNecessary(msg));*/

        System.out.println(msg.toString());

    }
//    public Message convertMessageIfNecessary(Object object) {
//        return object instanceof Message ? (Message)object : this.getRequiredMessageConverter().toMessage(object, new MessageProperties());
//    }
    private MessageConverter getRequiredMessageConverter() throws IllegalStateException {
    MessageConverter converter = new SimpleMessageConverter();
    if (converter == null) {
        throw new AmqpIllegalStateException("No 'messageConverter' specified. Check configuration of RabbitTemplate.");
    } else {
        System.out.println("--------------------------------------");
        return converter;
    }
}
    protected Message convertMessageIfNecessary(Object object) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setConsumerQueue(MqConfig.QUEUENAME);
        return object instanceof Message ? (Message)object : getRequiredMessageConverter().toMessage(object, messageProperties);
    }

}
