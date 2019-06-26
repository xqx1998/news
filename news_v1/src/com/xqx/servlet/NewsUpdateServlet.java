package com.xqx.servlet;

import com.xqx.control.NewsControl;
import com.xqx.model.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsUpdateServlet extends HttpServlet {
    NewsControl newsControl = new NewsControl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("news_id");
        int id0 = Integer.valueOf(id).intValue();
        String title = req.getParameter("title");
        String topic_id = req.getParameter("category");
        int topic_id0 = Integer.valueOf(topic_id).intValue();
        String time =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String user_id = req.getParameter("news_user_id");
        int user_id0 = Integer.parseInt(user_id);
        System.out.println(user_id0);
        String username = req.getParameter("news_username");
        String access = req.getParameter("news_access");
        int access0 = Integer.valueOf(access).intValue();
        String content = req.getParameter("content");

        resp.setContentType("text/html, charset=utf-8");
        resp.setCharacterEncoding("gbk");
        PrintWriter out = resp.getWriter();

        System.out.println(time);
        News news = new News(id0, title, topic_id0, time, user_id0, username, access0, content);

        int code = newsControl.newsAdd(news);
        if(1 == code){
            // out.println("新闻修改成功！");
            // req.setAttribute( "id", id0);
            // req.setAttribute("topic_id", topic_id0);
            // req.getRequestDispatcher( "newsLook.jsp").forward(req,resp);
            resp.sendRedirect("newsLook.jsp?id="+id0+"&&topic_id="+topic_id0);
            // out.println("<br />");
            // out.println(news.getNews_id());
            // out.println("<br />");
            // out.println(news.getNews_title());
            // out.println("<br />");
            // out.println("<br />");
            // out.println(news.getNews_TopicId());
            // out.println("<br />");
            // out.println(news.getNews_time());
            // out.println("<br />");
            // out.println(news.getNews_content());
            // out.println("<br />");
            // out.println(news.getNews_user_id());
            // out.println("<br />");
            // out.println(news.getNews_username());
        }else if(1062 == code){
            out.println("新闻修改失败，新闻已存在");
        }else{
            out.println("新闻修改失败，字段太长");
        }
        System.out.println(news.toString());
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
