package com.shan.reservation.service.impl;

import com.shan.reservation.bean.user;
import com.shan.reservation.mapper.userMapper;
import com.shan.reservation.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserSercieImpl implements UserService {
    @Autowired
    userMapper userMapper;

    @Override
    public user selectUserByNickName(String nickname) {
        List<user> list=userMapper.selectByExample(null);
        Iterator it=list.iterator();
        while(it.hasNext()){
            user user=(user)it.next();
            if(user.getUserName().equals(nickname)){
                return user;
            }
        }
        return null;
    }

    @Override
    public user selectUserById(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }
}
