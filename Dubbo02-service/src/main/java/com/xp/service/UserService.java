package com.xp.service;

import com.xp.api.IUser;
import com.xp.dao.UserMapper;
import com.xp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xp
 * @create 2018/11/29  19:21
 * @function 服务层,实现用户接口
 */

@Service
public class UserService implements IUser {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Map<String, Object> map) {
        return userMapper.getUser(map);
    }
}
