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
     * ��ӣ��޸�����
     * @param news
     * @return
     */
    public int newsAdd_Update(News news);

    /**
     * �������
     * @param news
     * @return
     */
    public int newsAdd(News news);

    /**
     * �޸�������Ϣ
     * @param news
     * @return
     */
    public int newsUpdate(News news);

    /**
     * ��ѯָ��id������Ϣ
     * @param news_id
     * @return
     */
    public News newsSelect(int news_id);

    public News newsSelectEnd();

    /**
     * ��ѯ��������
     * @return
     */
    public ArrayList<News> newsSelectAll();

    public ArrayList<News> newsSelectList(String sql);

    /**
     * ģ����ѯ�������Źؼ��ֵ�����
     * ����1.�Ѳ�ѯ�������ݿ�
     * ����2.�Ѳ�ѯ����������
     * @param keyword
     * @return
     */
    public ArrayList<News> newsDeatailsSelect(String keyword);


    /**
     * ɾ������
     * @param news_id
     * @return
     */
    public int newsDelete(int news_id);

    /**
     * ͬʱɾ���������
     * @param id_list
     * @return
     */
    public int newsDeleteMore(ArrayList<Integer> id_list);

    public int newsCount();
}
