package com.xqx.dao;

import com.xqx.model.Reply;

import java.util.ArrayList;

public interface ReplyDao {
    /**
     * Ìí¼Ó»Ø¸´
     * @return
     */
    public int replyAdd(Reply reply);
    public int replyUpdate();
    public Reply replySelect(String sql);
    public ArrayList<Reply> replySelectList(String sql);

}
