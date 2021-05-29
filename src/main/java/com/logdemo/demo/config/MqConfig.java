package com.logdemo.demo.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MqConfig {

    public static final String QUEUENAME = "regQueue";

    @Bean
    public Queue queue(){
        return new Queue(QUEUENAME);
    }
}
