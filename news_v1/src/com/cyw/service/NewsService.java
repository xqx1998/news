package com.cyw.service;

import com.cyw.model.News;

public interface NewsService {
    /**
     * 发帖发布功能
     * @param news
     * @return int
     */
    public int newsAdd(News news);
}
