package com.cyw.service;

import com.cyw.model.User;

/**
 * @author cyw
 * @Date 2019/5/13 19:39
 * @Package_Name: com.cyw.service
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
