package com.logdemo.demo.service;

import com.logdemo.demo.entity.VO.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    UserVO selectByPhone(String phone);

    UserVO selectByPwd(String phone, String password);
}
