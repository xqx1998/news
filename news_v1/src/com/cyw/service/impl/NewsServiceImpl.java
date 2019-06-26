package com.cyw.service.impl;

import com.cyw.dao.NewsDao;
import com.cyw.dao.impl.NewsDaoImpl;
import com.cyw.model.News;
import com.cyw.service.NewsService;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public int newsAdd(News news) {
        int code = newsDao.newsAdd_Update(news);
        if (1 == code) {
            return 1;
        }else if(1062  == code) {
            return 1062;
        }else
            return 0;
    }
}
