package com.receive.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.receive.demo.entity.VO.UserVO;
import com.receive.demo.mapper.ReceiveMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Autowired
    private ReceiveMapper receiveMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "regQueue")
    @RabbitHandler
    public void upd(Object msg){

        String[] str = msg.toString().split(" ");
        String[] str1 = str[0].split("'");
        JSONObject jsonObject = JSON.parseObject(str1[1]);
        UserVO userVO = jsonObject.toJavaObject(UserVO.class);
        receiveMapper.insert(userVO);



    }


}
