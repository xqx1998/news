package com.xqx.control;

import com.xqx.model.User;
import com.xqx.service.UserService;
import com.xqx.service.impl.UserServiceImpl;

/**
 * @author xqx
 * @Date 2019/5/13 19:37
 * @Package_Name: com.xqx.control
 * @Description：用户控制层类
 */
public class UserControl {
    UserService userService = new UserServiceImpl();

    /**
     * 登录验证
     * @param user
     * @return
     */
    public User login(User user) {
        User user_r = userService.login(user);
        System.out.println(user_r);
        return user_r;
    }

    public int register(User user){
        if (1 == userService.regist(user)) {
            return 1;
        }else if(1062 == userService.regist(user)){
            return 1062;
        }else
          return 0;
    }

    public User userDetailesSelect(int id) {
        User user_ds = userService.userDetailesSelect(id);
        return user_ds;
    }
}
