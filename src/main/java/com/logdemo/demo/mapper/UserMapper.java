package com.logdemo.demo.mapper;

import com.logdemo.demo.entity.VO.UserVO;
import com.rabbitmq.tools.json.JSONUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    @Select("select * from user where phone = #{phone}")
    UserVO selectByPhone(String phone);

    @Select("select * from user where phone = #{phone} and password = #{password}")
    UserVO selectByPwd(String phone, String password);
}
