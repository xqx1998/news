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
     * ��ӣ��޸ķ���
     * @param news
     * @return int
     */
    public int newsAdd_Update(News news);

    /**
     * ��ӷ���
     * @param news
     * @return int
     */
    public int newsAdd(News news);

    /**
     * �޸ķ�����Ϣ
     * @param news
     * @return int
     */
    public int newsUpdate(News news);

    /**
     * ��ѯָ��id������Ϣ
     * @param news_id
     * @return News
     */
    public News newsSelect(int news_id);

    /**
     * ��ѯ������������
     * @return News
     */
    public News newsSelectEnd();

    /**
     * ��ѯ���з���
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
     * ģ����ѯ���з����ؼ��ֵķ���
     * ����1.�Ѳ�ѯ�������ݿ�
     * ����2.�Ѳ�ѯ����������
     * @param keyword
     * @return  ArrayList<News>
     */
    public ArrayList<News> newsDeatailsSelect(String keyword);


    /**
     * ɾ������
     * @param news_id
     * @return int
     */
    public int newsDelete(int news_id);

    /**
     * ͬʱɾ���������
     * @param id_list
     * @return int
     */
    public int newsDeleteMore(ArrayList<Integer> id_list);

    /**
     * ��������ͳ��
     * @return
     */
    public int newsCount();

    /**
     * �������ʸ���
     * @param sql
     * @return
     */
    public int newsAccessUpdate(String sql);
}
