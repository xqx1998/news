package com.cyw.model;

/**
 * @author cyw
 * @fileName:
 * @Date 2019/5/20 10:11
 * 发帖模型层类 实体类
 *
 */
public class News {
    private int news_id; //发帖id
    private String news_title; //发帖标题
    private int news_TopicId;  //发帖所属主题id
    private String news_topic; //主题
    private String news_time;  //发布时间
    private int news_user_id;   //发布者id
    private String news_username;//发布者用户名
    private int news_access; //访问量
    private String news_content;    //内容

    /**
     * 无参构造方法，空构造
     */
    public News() {
    }

    /**
     *
     * @param news_id
     * @param news_title
     * @param news_content
     */
    public News(int news_id, String news_title, String news_content) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_content = news_content;
    }

    /**
     *
     * @param news_id
     * @param news_title
     * @param news_TopicId
     * @param news_time
     * @param news_user_id
     * @param news_username
     */
    public News(int news_id, String news_title, int news_TopicId, String news_time, int news_user_id, String news_username) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_TopicId = news_TopicId;
        this.news_time = news_time;
        this.news_user_id = news_user_id;
        this.news_username = news_username;
    }

    /**
     *
     * @param news_id
     * @param news_title
     * @param news_TopicId
     * @param news_time
     * @param news_user_id
     * @param news_username
     * @param news_content
     */
    public News(int news_id, String news_title, int news_TopicId, String news_time, int news_user_id, String news_username, String news_content) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_TopicId = news_TopicId;
        this.news_time = news_time;
        this.news_user_id = news_user_id;
        this.news_username = news_username;
        this.news_content = news_content;
    }

    /**
     *
     * @param news_id
     * @param news_title
     * @param news_TopicId
     * @param news_time
     * @param news_user_id
     * @param news_username
     * @param news_access
     * @param news_content
     */
    public News(int news_id, String news_title, int news_TopicId, String news_time, int news_user_id, String news_username, int news_access, String news_content) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_TopicId = news_TopicId;
        this.news_time = news_time;
        this.news_user_id = news_user_id;
        this.news_username = news_username;
        this.news_access = news_access;
        this.news_content = news_content;

    }

    /**
     *
     * @param news_id
     * @param news_title
     * @param news_TopicId
     * @param news_topic
     * @param news_time
     * @param news_user_id
     * @param news_username
     * @param news_access
     */
    public News(int news_id, String news_title, int news_TopicId, String news_topic, String news_time, int news_user_id, String news_username, int news_access) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_TopicId = news_TopicId;
        this.news_topic = news_topic;
        this.news_time = news_time;
        this.news_user_id = news_user_id;
        this.news_username = news_username;
        this.news_access = news_access;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public int getNews_TopicId() {
        return news_TopicId;
    }

    public void setNews_TopicId(int news_TopicId) {
        this.news_TopicId = news_TopicId;
    }

    public String getNews_topic() {
        return news_topic;
    }

    public void setNews_topic(String news_topic) {
        this.news_topic = news_topic;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public int getNews_user_id() {
        return news_user_id;
    }

    public void setNews_user_id(int news_user_id) {
        this.news_user_id = news_user_id;
    }

    public String getNews_username() {
        return news_username;
    }

    public void setNews_username(String news_username) {
        this.news_username = news_username;
    }

    public int getNews_access() {
        return news_access;
    }

    public void setNews_access(int news_access) {
        this.news_access = news_access;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", news_title='" + news_title + '\'' +
                ", news_TopicId=" + news_TopicId +
                ", news_topic='" + news_topic + '\'' +
                ", news_time='" + news_time + '\'' +
                ", news_user_id=" + news_user_id +
                ", news_username='" + news_username + '\'' +
                ", news_access=" + news_access +
                ", news_content='" + news_content + '\'' +
                '}';
    }
}
