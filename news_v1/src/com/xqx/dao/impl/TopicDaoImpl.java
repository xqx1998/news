package com.xqx.dao.impl;

import com.xqx.dao.TopicDao;
import com.xqx.model.Topic;
import com.xqx.tools.DButil;
import config.TopicSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopicDaoImpl extends TopicSQL implements TopicDao {
    DButil db = new DButil();
    @Override
    public Topic select(int topic_id) {
        Topic topic = null;;
        Connection conn = db.getConnection();
        // String sql = " SELECT topic_id, topic_name FROM topic where topic_id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ps.setInt(1,topic_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                topic = new Topic(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
        return topic;
    }

    @Override
    public ArrayList<Topic> selectAll() {
        ArrayList<Topic> topicArrayList = new ArrayList<Topic>();;
        Connection conn = db.getConnection();
        // String sql = " SELECT topic_id, topic_name FROM news.topic order by topic_id asc ";
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(11);
                topicArrayList.add(new Topic(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
        return topicArrayList;
    }
}
