package com.logdemo.demo.service.impl;

import com.logdemo.demo.entity.VO.UserVO;
import com.logdemo.demo.mapper.UserMapper;
import com.logdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserVO selectByPhone(String phone) {

        System.out.println(phone);
        UserVO user = userMapper.selectByPhone(phone);

        return user;
    }

    @Override
    public UserVO selectByPwd(String phone, String password) {

        return userMapper.selectByPwd(phone,password);
    }


}
