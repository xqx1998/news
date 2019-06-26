package com.xqx.service;

import com.xqx.model.User;

/**
 * @author xqx
 * @Date 2019/5/13 19:39
 * @Package_Name: com.xqx.service
 * @Description��
 */
public interface UserService {
    /**
     * ��¼����
     * @param user
     * @return User
     */
    public User login(User user);

    /**
     * ע�Ṧ��
     * @param user
     * @return int
     */
    public int regist(User user);

    /**
     * ��ѯ�û���ϸ��Ϣ����
     * @param id
     * @return User
     */
    public User userDetailesSelect(int id);
}
