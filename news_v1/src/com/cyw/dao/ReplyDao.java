package com.cyw.dao;

import com.cyw.model.Reply;

import java.util.ArrayList;

public interface ReplyDao {
    /**
     * 添加回复
     * @return
     */
    public int replyAdd(Reply reply);

    /**
     * 更新回复功能
     * @return
     */
    public int replyUpdate();

    /**
     *  查询回复信息
     * @param sql
     * @return Reply
     */
    public Reply replySelect(String sql);

    /**
     * 回复信息列表
     * @param sql
     * @return ArrayList<Reply>
     */
    public ArrayList<Reply> replySelectList(String sql);

}
