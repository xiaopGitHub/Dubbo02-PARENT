package com.xp.api;

import com.xp.vo.User;

import java.util.Map;

/**
 * @author xp
 * @create 2018/11/29  17:14
 * @function 用户接口
 */
public interface IUser {
    User getUser(Map<String,Object> map);
}
