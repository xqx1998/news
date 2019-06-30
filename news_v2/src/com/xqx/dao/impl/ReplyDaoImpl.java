package com.xqx.dao.impl;

import com.xqx.dao.ReplyDao;
import com.xqx.model.Reply;
import com.xqx.tools.DButil;
import config.ReplySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDaoImpl extends ReplySql implements ReplyDao {
    DButil db = new DButil();
    @Override
    public int replyAdd(Reply reply) {
        //获取数据库连接
        Connection connection = db.getConnection();
        //创建sql载体
        PreparedStatement ps = null;
        int rows = 0;
        try {
            if (1==reply.getReply_level()) {
                ps = connection.prepareStatement(REPLY_ADD1);
                //SQL参数赋值
                ps.setInt(1, reply.getReply_news_id());
                ps.setInt(2, reply.getReply_user_id());
                ps.setInt(3, reply.getReply_level());
                ps.setString(4, reply.getReply_content());
                ps.setString(5, reply.getReply_time());
            }else if (2==reply.getReply_level()){
                ps = connection.prepareStatement(REPLY_ADD2);
                //SQL参数赋值
                ps.setInt(1, reply.getReply_news_id());
                ps.setInt(2, reply.getReply_user_id());
                ps.setInt(3, reply.getReply_level());
                ps.setInt(4, reply.getReply_reply_id());
                ps.setString(5, reply.getReply_content());
                ps.setString(6, reply.getReply_time());
            }
            //执行SQL语句
            rows = ps.executeUpdate();
            if (rows == 1)  {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
        db.close(null, ps, connection);
        return 0;
    }

    @Override
    public int replyUpdate() {
        return 0;
    }

    @Override
    public Reply replySelect(String sql) {
        return null;
    }

    @Override
    public ArrayList<Reply> replySelectList(String sql) {
        ArrayList<Reply> replyArrayList = new ArrayList<Reply>();
        Connection conn = db.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                replyArrayList.add(new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
            db.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyArrayList;
    }
}
