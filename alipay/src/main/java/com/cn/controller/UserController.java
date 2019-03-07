package com.cn.controller;

import com.cn.utils.ResultBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cn.domain.User;
import com.cn.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public ResultBean getUserInfo(@RequestParam("id") String id) {
    	System.out.println(id);
        User user = userService.getUserInfo(id);
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        return ResultBean.ok(user);
    }
}
