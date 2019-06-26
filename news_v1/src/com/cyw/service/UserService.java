package com.cyw.service;

import com.cyw.model.User;

/**
 * @author cyw
 * @Date 2019/5/13 19:39
 * @Package_Name: com.cyw.service
 * @Description£º
 */
public interface UserService {
    public User login(User user);
    public int regist(User user);
    public User userDetailesSelect(int id);
}
