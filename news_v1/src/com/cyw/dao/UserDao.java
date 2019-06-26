package com.cyw.dao;

import com.cyw.model.User;

import java.util.ArrayList;

/**
 * @author cyw
 * @Date 2019/5/13 17:33
 * @Package_Name: com.cyw.Servlet
 * @Description��
 */
public interface UserDao{
    /**
     * ����û�
     * @param user
     * @return
     */
    public int userAdd(User user);

    /**
     * ��ѯ�û�
     * @param username
     * @return
     */
    public User userSelect(String username);
    public User userSelect(int user_id);

    /**
     * ��ѯ�����û�
     * @return
     */
    public ArrayList<User> userSelectAll();

    /**
     * ��ѯָ��id�û���ϸ��Ϣ
     * @param id
     * @return
     */
    public User userDetailesSelect(int id);

    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public int userUpdate(User user);

    /**
     * ɾ���û�
     * @param user
     * @return
     */
    public int userDelete(User user);

    /**
     * ͬʱɾ�����
     * @param id_list
     * @return
     */
    public int userDelete(ArrayList<Integer> id_list);
}
