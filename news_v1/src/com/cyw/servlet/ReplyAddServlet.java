package com.cyw.servlet;

import com.cyw.dao.ReplyDao;
import com.cyw.dao.impl.ReplyDaoImpl;
import com.cyw.model.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/ReplyAddServlet")
public class ReplyAddServlet extends HttpServlet {
    ReplyDao replyDao = new ReplyDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html, charset=utf-8");
        resp.setCharacterEncoding("gbk");
        PrintWriter out = resp.getWriter();
        int reply_id = 0;
        String reply_news_id = req.getParameter("reply_news_id");
        String reply_user_id = req.getParameter("reply_user_id");
        if(reply_user_id.length()!=0 || reply_user_id.split(" ").equals("")) {
            String reply_level = req.getParameter("reply_level");
            String reply_reply_id = req.getParameter("reply_reply_id");
            int reply_reply_id0 = 0;
            // System.out.println(reply_reply_id);
            if (reply_reply_id != null) {
                reply_reply_id0 = Integer.valueOf(reply_reply_id).intValue();
            }
            int reply_news_id0 = Integer.valueOf(reply_news_id).intValue();
            int reply_user_id0 = Integer.valueOf(reply_user_id).intValue();
            int reply_level0 = Integer.valueOf(reply_level).intValue();
            String reply_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String reply_content = req.getParameter("reply_content");
            String topic = req.getParameter("topic");
            System.out.println("topic:"+topic);
            System.out.println(reply_time);
            Reply reply = new Reply(reply_id, reply_news_id0, reply_user_id0, reply_level0, reply_reply_id0, reply_time, reply_content);
            int code = replyDao.replyAdd(reply);
            if (1 == code) {
                resp.sendRedirect("news.jsp?id=" + reply_news_id + "&&topic=" + topic);
            } else if (1062 == code) {
                out.println("ÆÀÂÛÊ§°Ü£¬ÆÀÂÛÒÑ´æÔÚ");
            } else {
                out.println("ÆÀÂÛÊ§°Ü£¬×Ö¶ÎÌ«³¤");
            }
            System.out.println(reply.toString());
        }else{
            out.println("<script> alert('ÇëÏÈµÇÂ¼£¡');location.href='login.jsp';</script>");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
