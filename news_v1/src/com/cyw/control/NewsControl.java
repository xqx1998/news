package com.cyw.control;

import com.cyw.model.News;
import com.cyw.service.NewsService;
import com.cyw.service.impl.NewsServiceImpl;

/**
 * ·¢Ìû¿ØÖÆ²ãÀà
 *
 */
public class NewsControl {
    NewsService newsService = new NewsServiceImpl();
    public int newsAdd(News news){
        if(1 == newsService.newsAdd(news)){
            return 1;
        }else if(1062 == newsService.newsAdd(news)){
            return 1062;
        }else
            return 0;
    }
}
