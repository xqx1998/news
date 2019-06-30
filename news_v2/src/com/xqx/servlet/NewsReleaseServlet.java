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

/**
 * 发帖发布处理
 */
public class NewsReleaseServlet extends HttpServlet {
    NewsControl newsControl = new NewsControl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html, charset=utf-8");
        resp.setCharacterEncoding("gbk");
        PrintWriter out = resp.getWriter();
        int id = 0;
        String title = req.getParameter("title");
        String topic_id = req.getParameter("category");
        int topic_id0 = Integer.valueOf(topic_id).intValue();
        String time =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String user_id = req.getParameter("news_user_id");
        if(user_id.length()!=0 || user_id.split(" ").equals("")) {
            int user_id0 = Integer.parseInt(user_id);
            System.out.println(user_id0);
            String username = req.getParameter("news_username");
            String content = req.getParameter("content");

            System.out.println(time);
            News news = new News(id, title, topic_id0, time, user_id0, username, content);
            int code = newsControl.newsAdd(news);
            if (1 == code) {
                // out.println("新闻发布成功！");
                // req.setAttribute( "id", id);
                // req.setAttribute("topic_id", topic_id0);
                // req.getRequestDispatcher( "newsLook.jsp").forward(req,resp);
                resp.sendRedirect("newsLook.jsp?id=" + id + "&&topic_id=" + topic_id0);
            } else if (1062 == code) {
                out.println("新闻发布失败，新闻已存在");
            } else {
                out.println("新闻发布失败，字段太长");
            }
            System.out.println(news.toString());
        }else{
            out.println("<script> alert('请先登录！');location.href='../login.jsp';</script>");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
