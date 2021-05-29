package com.logdemo.demo.controller;

import com.logdemo.demo.entity.VO.UserVO;
import com.logdemo.demo.service.UserService;
import com.logdemo.demo.util.MqSender;
import com.logdemo.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MqSender mqSender;

    @PostMapping("/login")
    public R login(@RequestBody UserVO userVO){

        if (userVO.getUsername().length()>20 || userVO.getPassword().length()>20){
            return R.error().message("非法参数");
        }
        UserVO user = userService.selectByPwd(userVO.getPhone(),userVO.getPassword());
        if(user != null) {
            return R.ok().message("登录成功");
        } else {
            return R.error().message("密码或用户名不正确");
        }
    }

    @PostMapping("/reg")
    public R reg(@RequestBody UserVO userVo){

        if (userVo.getUsername().length()>20 || userVo.getPassword().length()>20){
            return R.error().message("非法参数");
        }
        UserVO res = userService.selectByPhone(userVo.getPhone());
        if (res!=null) {
            return R.error().message("用户已经存在");
        } else {
            mqSender.send(userVo);
            return R.ok().message("注册成功");
        }

    }

}
