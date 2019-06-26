package com.cyw.dao;

import com.cyw.model.Reply;

import java.util.ArrayList;

public interface ReplyDao {
    /**
     * ��ӻظ�
     * @return
     */
    public int replyAdd(Reply reply);

    /**
     * ���»ظ�����
     * @return
     */
    public int replyUpdate();

    /**
     *  ��ѯ�ظ���Ϣ
     * @param sql
     * @return Reply
     */
    public Reply replySelect(String sql);

    /**
     * �ظ���Ϣ�б�
     * @param sql
     * @return ArrayList<Reply>
     */
    public ArrayList<Reply> replySelectList(String sql);

}
