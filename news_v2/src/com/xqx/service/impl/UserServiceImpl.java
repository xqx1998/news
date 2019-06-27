package com.xqx.service.impl;

import com.xqx.dao.UserDao;
import com.xqx.dao.impl.UserDaoImpl;
import com.xqx.model.User;
import com.xqx.service.UserService;

/**
 * @author xqx
 * @Date 2019/5/13 20:35
 * @Package_Name: service
 * @Description£º
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public UserServiceImpl() {

    }

    @Override
    public User login(User user) {
        User user_r = userDao.userSelect(user.getUsername());
        return  user_r;
    }

    @Override
    public int regist(User user) {
        if (1 == userDao.userAdd(user)) {
            return 1;
        }else if(1062  == userDao.userAdd(user)) {
            return 1062;
        }else
            return 0;
    }

    @Override
    public User userDetailesSelect(int id) {
        User user_ds = userDao.userDetailesSelect(id);
        return user_ds;
    }
}
