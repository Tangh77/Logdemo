package com.receive.demo.entity.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {

//    private static final long SerializableID = 123456789L;

    private Long id;

    private String username;

    private String password;

    private String phone;

    private String address;

    private int sex;

}
