package com.xqx.model;

/**
 * @author xqx
 * @fileName:
 * @Date 2019/5/20 10:21
 * @Package_Name: 主题实体类
 */
public class Topic {
    private int topic_id; //主题id
    private String topic_name; //主题名称

    public Topic() {
    }

    /**
     *
     * @param topic_id
     * @param topic_name
     */
    public Topic(int topic_id, String topic_name) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", topic_name='" + topic_name + '\'' +
                '}';
    }
}
