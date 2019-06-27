package com.xqx.service.impl;

import com.xqx.dao.NewsDao;
import com.xqx.dao.impl.NewsDaoImpl;
import com.xqx.model.News;
import com.xqx.service.NewsService;

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
