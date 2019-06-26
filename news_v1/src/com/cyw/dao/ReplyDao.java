package com.cyw.dao;

import com.cyw.model.Reply;

import java.util.ArrayList;

public interface ReplyDao {
    /**
     * ��ӻظ�
     * @return
     */
    public int replyAdd(Reply reply);
    public int replyUpdate();
    public Reply replySelect(String sql);
    public ArrayList<Reply> replySelectList(String sql);

}
