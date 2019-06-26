package com.cyw.model;

public class Reply {
    private int reply_id;     //评论或回复id
    private int reply_news_id; //评论的发帖id
    private int reply_user_id; //评论者id
    private int reply_level;    //
    private int reply_reply_id;
    private String reply_time;
    private String reply_content;

    public Reply() {}

    public Reply(int reply_id, int reply_news_id, int reply_user_id, int reply_level, int reply_reply_id, String reply_time, String reply_content) {
        this.reply_id = reply_id;
        this.reply_news_id = reply_news_id;
        this.reply_user_id = reply_user_id;
        this.reply_level = reply_level;
        this.reply_reply_id = reply_reply_id;
        this.reply_time = reply_time;
        this.reply_content = reply_content;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public int getReply_news_id() {
        return reply_news_id;
    }

    public void setReply_news_id(int reply_news_id) {
        this.reply_news_id = reply_news_id;
    }

    public int getReply_user_id() {
        return reply_user_id;
    }

    public void setReply_user_id(int reply_user_id) {
        this.reply_user_id = reply_user_id;
    }

    public int getReply_level() {
        return reply_level;
    }

    public void setReply_level(int reply_level) {
        this.reply_level = reply_level;
    }

    public int getReply_reply_id() {
        return reply_reply_id;
    }

    public void setReply_reply_id(int reply_reply_id) {
        this.reply_reply_id = reply_reply_id;
    }

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", reply_news_id=" + reply_news_id +
                ", reply_user_id=" + reply_user_id +
                ", reply_level=" + reply_level +
                ", reply_time='" + reply_time + '\'' +
                ", reply_content='" + reply_content + '\'' +
                '}';
    }
}
