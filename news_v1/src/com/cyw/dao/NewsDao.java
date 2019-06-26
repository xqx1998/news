package com.cyw.dao;

import com.cyw.model.News;

import java.util.ArrayList;

/**
 * @author cyw
 * @fileName:
 * @Date 2019/5/20 10:37
 * @Package_Name:
 */
public interface NewsDao {
    /**
     * 添加，修改新闻
     * @param news
     * @return
     */
    public int newsAdd_Update(News news);

    /**
     * 添加新闻
     * @param news
     * @return
     */
    public int newsAdd(News news);

    /**
     * 修改新闻信息
     * @param news
     * @return
     */
    public int newsUpdate(News news);

    /**
     * 查询指定id新闻信息
     * @param news_id
     * @return
     */
    public News newsSelect(int news_id);

    public News newsSelectEnd();

    /**
     * 查询所有新闻
     * @return
     */
    public ArrayList<News> newsSelectAll();

    public ArrayList<News> newsSelectList(String sql);

    /**
     * 模糊查询含有新闻关键字的新闻
     * 方法1.把查询留给数据库
     * 方法2.把查询留给服务器
     * @param keyword
     * @return
     */
    public ArrayList<News> newsDeatailsSelect(String keyword);


    /**
     * 删除新闻
     * @param news_id
     * @return
     */
    public int newsDelete(int news_id);

    /**
     * 同时删除多个新闻
     * @param id_list
     * @return
     */
    public int newsDeleteMore(ArrayList<Integer> id_list);

    public int newsCount();
}
