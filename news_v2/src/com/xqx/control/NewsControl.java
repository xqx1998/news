package com.xqx.control;

import com.xqx.model.News;
import com.xqx.service.NewsService;
import com.xqx.service.impl.NewsServiceImpl;

/**
 * �������Ʋ���
 *
 */
public class NewsControl {
    NewsService newsService = new NewsServiceImpl();

    /**
     * ������ӹ���
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
