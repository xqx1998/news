package com.cyw.dao.impl;

import com.cyw.dao.NewsDao;
import com.cyw.model.News;
import com.cyw.tools.DButil;
import config.NewsSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cyw
 * @fileName:
 * @Date 2019/5/20 10:44
 * @Package_Name:
 */
public class NewsDaoImpl extends NewsSQL implements NewsDao {
    DButil db = new DButil();
    @Override
    public int newsAdd_Update(News news) {
        if(news.getNews_id()==0){
            int code_add = newsAdd(news);
            if(code_add==1)
                return 1;
            else if(code_add == 1062)
                return 1062;
            else
                return 0;
        }else if(news.getNews_id()!=0){
            int code_update = newsUpdate(news);
            if(code_update==1)
                return 1;
            else if(code_update == 1062)
                return 1062;
            else
                return 0;
        }
        return 0;
    }

    public int newsAdd(News news) {
        //获取数据库连接
        Connection connection = db.getConnection();
        //定义用户表插入用户信息sql语句
        // String sql = "INSERT INTO `news`.`news` (`news_title`, `news_topic_id`, `news_time`, `news_user_id`, `news_username`,`news_content`) VALUES (?, ?, ?, ?, ?, ?)";
        //创建sql载体
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(NEWS_ADD);
            //SQL参数赋值
            ps.setString(1, news.getNews_title());
            ps.setInt(2, news.getNews_TopicId());
            ps.setString(3, news.getNews_time());
            ps.setInt(4, news.getNews_user_id());
            ps.setString(5, news.getNews_username());
            ps.setString(6, news.getNews_content());
            //执行SQL语句
            int rows = ps.executeUpdate();
            if (rows == 1)  {
                    return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
        return 0;
    }

    @Override
    public int newsUpdate(News news) {
        //获取数据库连接
        Connection connection = db.getConnection();
        //定义用户表插入用户信息sql语句
        // String sql = "UPDATE `news`.`news` t SET t.`news_title` = ?, t.`news_topic_id` = ?, t.`news_time` = ?, t.`news_user_id` = ?, t.`news_username` = ?, t.`news_access` = ?, t.`news_content` = ? WHERE t.`news_id` = ?";
        //创建sql载体
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(NEWS_UPDATE);
            //SQL参数赋值
            ps.setString(1,news.getNews_title());
            ps.setInt(2, news.getNews_TopicId());
            ps.setString(3, news.getNews_time());
            ps.setInt(4, news.getNews_user_id());
            ps.setString(5, news.getNews_username());
            ps.setInt(6, news.getNews_access());
            ps.setString(7, news.getNews_content());
            ps.setInt(8, news.getNews_id());
            //执行SQL语句
            int rows = ps.executeUpdate();
            if (rows == 1)  {
                    return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
        return 0;
    }

    @Override
    public News newsSelect(int news_id) {
        News news = null;
        Connection conn = db.getConnection();

        // String sql = "SELECT news_id, news_title, news_topic_id, news_time, news_user_id, news_username, news_access, news_content FROM news.news where news_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(NEWS_SELECT);
            System.out.println(news_id);
            ps.setInt(1, news_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                news = new News(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
//                news = new News(1,"1",1,"1",1,"1",1,"1");

            }
            db.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    public News newsSelectEnd() {
        News news = null;
        Connection conn = db.getConnection();
        // String sql = "SELECT news_id, news_title, news_topic_id, news_time, news_user_id, news_username FROM news.news order by news_id desc LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(NEWS_SELECT_END);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                news = new News(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
            db.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public ArrayList<News> newsSelectAll() {
        ArrayList<News> newsArrayList = new ArrayList<News>();
        Connection conn = db.getConnection();
        String sql = "SELECT news_id, news_title, news_topic_id, news_time, news_user_id, news_username FROM news.news order by news_id desc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                newsArrayList.add(new News(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            db.close(rs, ps, conn);db.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsArrayList;
    }

    @Override
    public ArrayList<News> newsSelectList(String sql) {
        ArrayList<News> newsArrayList = new ArrayList<News>();
        Connection conn = db.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                newsArrayList.add(new News(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8)));
            }
            db.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsArrayList;
    }

    @Override
    public ArrayList<News> newsDeatailsSelect(String keyword) {
        return null;
    }

    @Override
    public int newsDelete(int id) {
        Connection conn = db.getConnection();
        // String sql = "DELETE FROM `news`.`news` WHERE `news_id` = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(NEWS_DELETE);
            System.out.println(id);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();




































































































































































































































































































































































            if(rows == 1){
                return 1;
            }
            db.close(null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int newsDeleteMore(ArrayList<Integer> id_list) {
        return 0;
    }

    @Override
    public int newsCount() {
        Connection conn = db.getConnection();
        String sql = "select count(*) from `news`";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            db.close(null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
