package com.xqx.service;

import com.xqx.model.User;

/**
 * @author xqx
 * @Date 2019/5/13 19:39
 * @Package_Name: com.xqx.service
 * @Description：
 */
public interface UserService {
    /**
     * 登录功能
     * @param user
     * @return User
     */
    public User login(User user);

    /**
     * 注册功能
     * @param user
     * @return int
     */
    public int regist(User user);

    /**
     * 查询用户详细信息功能
     * @param id
     * @return User
     */
    public User userDetailesSelect(int id);
}
