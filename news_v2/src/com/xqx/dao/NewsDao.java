package com.xqx.dao;

import com.xqx.model.News;

import java.util.ArrayList;

/**
 * @author xqx
 * @fileName:
 * @Date 2019/5/20 10:37
 * @Package_Name:
 */
public interface NewsDao {
    /**
     * 添加，修改发帖
     * @param news
     * @return int
     */
    public int newsAdd_Update(News news);

    /**
     * 添加发帖
     * @param news
     * @return int
     */
    public int newsAdd(News news);

    /**
     * 修改发帖信息
     * @param news
     * @return int
     */
    public int newsUpdate(News news);

    /**
     * 查询指定id发帖信息
     * @param news_id
     * @return News
     */
    public News newsSelect(int news_id);

    /**
     * 查询最新首条发帖
     * @return News
     */
    public News newsSelectEnd();

    /**
     * 查询所有发帖
     * @return ArrayList<News>
     */
    public ArrayList<News> newsSelectAll();

    /**
     *
     * @param sql
     * @return ArrayList<News>
     */
    public ArrayList<News> newsSelectList(String sql);

    /**
     * 模糊查询含有发帖关键字的发帖
     * 方法1.把查询留给数据库
     * 方法2.把查询留给服务器
     * @param keyword
     * @return  ArrayList<News>
     */
    public ArrayList<News> newsDeatailsSelect(String keyword);


    /**
     * 删除发帖
     * @param news_id
     * @return int
     */
    public int newsDelete(int news_id);

    /**
     * 同时删除多个发帖
     * @param id_list
     * @return int
     */
    public int newsDeleteMore(ArrayList<Integer> id_list);

    /**
     * 发帖数量统计
     * @return
     */
    public int newsCount();

    /**
     * 发帖访问更新
     * @param sql
     * @return
     */
    public int newsAccessUpdate(String sql);
}
