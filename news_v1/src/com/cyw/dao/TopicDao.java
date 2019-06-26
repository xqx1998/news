package com.cyw.dao;

import com.cyw.model.Topic;

import java.util.ArrayList;

public interface TopicDao {
    /**
     * 指定主题id查找功能
     * @param topic_id
     * @return Topic
     */
    public Topic select(int topic_id);

    /**
     * 主题列表功能
     * @return ArrayList<Topic>
     */
    public ArrayList<Topic> selectAll();
}
