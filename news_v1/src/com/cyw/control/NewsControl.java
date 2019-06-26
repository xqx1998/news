package com.cyw.control;

import com.cyw.model.News;
import com.cyw.service.NewsService;
import com.cyw.service.impl.NewsServiceImpl;

/**
 * 发帖控制层类
 *
 */
public class NewsControl {
    NewsService newsService = new NewsServiceImpl();

    /**
     * 发帖添加功能
     * @param news
     * @return
     */
    public int newsAdd(News news){
        if(1 == newsService.newsAdd(news)){
            return 1;
        }else if(1062 == newsService.newsAdd(news)){
            return 1062;
        }else
            return 0;
    }
}
