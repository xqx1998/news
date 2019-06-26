package com.xqx.service;

import com.xqx.model.User;

/**
 * @author xqx
 * @Date 2019/5/13 19:39
 * @Package_Name: com.xqx.service
 * @Description£º
 */
public interface UserService {
    public User login(User user);
    public int regist(User user);
    public User userDetailesSelect(int id);
}
