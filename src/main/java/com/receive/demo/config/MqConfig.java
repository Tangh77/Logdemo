package com.receive.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.receive.demo.entity.VO.UserVO;
import com.receive.demo.mapper.ReceiveMapper;
import com.receive.demo.service.ReceiveUserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Autowired
    private ReceiveUserService receiveUserService;

    @RabbitListener(queues = "regQueue")
    @RabbitHandler
    public void upd(Object msg){
        String[] str = msg.toString().split(" ");
        String[] str1 = str[0].split("'");
        JSONObject jsonObject = JSON.parseObject(str1[1]);
        //一般，这个地方的盘空逻辑要交给service
        UserVO userVO = jsonObject.toJavaObject(UserVO.class);
        receiveUserService.insertUserInfo(userVO);
    }
}
