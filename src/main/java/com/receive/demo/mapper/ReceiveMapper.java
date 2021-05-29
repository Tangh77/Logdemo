package com.receive.demo.mapper;

import com.receive.demo.entity.VO.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveMapper {

    @Insert("insert into user (id,username,password,phone,address,sex) values (#{id},#{username},#{password},#{phone},#{address},#{sex})")
    void insert(UserVO userVO);

}
