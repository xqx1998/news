package com.xqx.control;

import com.xqx.model.User;
import com.xqx.service.UserService;
import com.xqx.service.impl.UserServiceImpl;

/**
 * @author xqx
 * @Date 2019/5/13 19:37
 * @Package_Name: com.xqx.control
 * @Description���û����Ʋ���
 */
public class UserControl {
    UserService userService = new UserServiceImpl();

    /**
     * ��¼��֤
     * @param user
     * @return
     */
    public User login(User user) {
        User user_r = userService.login(user);
        return user_r;
    }

    /**
     * �û�ע��
     * @param user
     * @return int
     */
    public int register(User user){
        if (1 == userService.regist(user)) {
            return 1;
        }else if(1062 == userService.regist(user)){
            return 1062;
        }else
          return 0;
    }

    /**
     * �û���ϸ��Ϣ��ѯ
     * @param id
     * @return User
     */
    public User userDetailesSelect(int id) {
        User user_ds = userService.userDetailesSelect(id);
        return user_ds;
    }
}