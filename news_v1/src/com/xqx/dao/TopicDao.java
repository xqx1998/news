package com.xqx.dao;

import com.xqx.model.Topic;

import java.util.ArrayList;

public interface TopicDao {
    public Topic select(int topic_id);
    public ArrayList<Topic> selectAll();
}
