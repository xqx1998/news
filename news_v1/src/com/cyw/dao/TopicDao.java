package com.cyw.dao;

import com.cyw.model.Topic;

import java.util.ArrayList;

public interface TopicDao {
    public Topic select(int topic_id);
    public ArrayList<Topic> selectAll();
}
