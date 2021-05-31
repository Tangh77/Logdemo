package com.receive.demo.service.impl;

import com.receive.demo.entity.VO.UserVO;
import com.receive.demo.mapper.ReceiveMapper;
import com.receive.demo.service.ReceiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReceiveUserServiceImpl implements ReceiveUserService {
    @Autowired
    ReceiveMapper receiveMapper;

    @Override
    public void insertUserInfo(UserVO userVO) {
        if (userVO!=null){
            receiveMapper.insert(userVO);
        }
    }
}
