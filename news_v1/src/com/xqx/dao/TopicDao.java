package com.xqx.dao;

import com.xqx.model.Topic;

import java.util.ArrayList;

public interface TopicDao {
    /**
     * ָ������id���ҹ���
     * @param topic_id
     * @return Topic
     */
    public Topic select(int topic_id);

    /**
     * �����б���
     * @return ArrayList<Topic>
     */
    public ArrayList<Topic> selectAll();
}
