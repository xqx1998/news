package com.cyw.servlet;

import com.cyw.dao.NewsDao;
import com.cyw.dao.impl.NewsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewsDeleteServlet extends HttpServlet {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        System.out.println(id);
        int id0 = Integer.valueOf(id).intValue();

        resp.setContentType("text/html, charset=utf-8");
        resp.setCharacterEncoding("gbk");
        PrintWriter out = resp.getWriter();

        int code = 0;
        // int code = newsDao.userDelete(id0);
        if(1 == code){
//            out.println("<script> alert('����ɾ���ɹ���');history.back(-1);</script>");
            out.println("<script> alert('����ɾ���ɹ���');self.location=document.referrer;</script>");
//            out.println("<a href=\"javascript:\" onclick=\"self.location=document.referrer;\">������һҳ��ˢ��</a>");

//            out.println("<script> alert('����ɾ���ɹ���');<a href=\"javascript:\" onclick=\"self.location=document.referrer;\">;");

            out.println("<br />");

        }else{
            out.println("����ɾ��ʧ��");
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
