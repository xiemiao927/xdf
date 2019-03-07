package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.User;
import com.cn.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(String id){
        User user=userMapper.findUserInfo(id);
        //User user=null;
        return user;
    }

}
