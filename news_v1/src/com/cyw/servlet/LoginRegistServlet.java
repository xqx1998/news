package com.xqx.servlet;

import com.xqx.control.UserControl;
import com.xqx.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xqx
 * @fileName:LoginRegistServlet
 * @Date 2019/5/13 20:31
 * @Package_Name: com.xqx.servlet
 * @Description： 用户登录注册处理
 */
public class LoginRegistServlet extends HttpServlet {
    UserControl userControl = new UserControl();

    public void init() throws ServletException {
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {

            req.setCharacterEncoding("utf-8");  //设置接收数据的编码方式
            res.setCharacterEncoding("utf-8");  //设置发送数据的编码方式
            String username = req.getParameter("username");  //获取login_register.jsp表单提交的username值
            System.out.println("username:" + username);
            String password = req.getParameter("password");
            System.out.println(username + "," + password);
            String type = req.getParameter("type"); //获取login_register.jsp表单提交的type值
            System.out.println("type:" + type);
            //设置转发页面的类型和编码方式
            res.setContentType("text/html;charset=utf-8");
            //创建输出对象
            PrintWriter out = res.getWriter();
            //在网页中输出内容
            //判断是否为登录操作
            if (type.equals("login")) {
                /**
                 * 登录处理操作会会出现的情况
                 * 前端处理：限定格式
                 * 后端处理：1、用户不存在 2、密码错误 3、验证通过
                 */
                //创建session对象
                HttpSession session = req.getSession();
                //获取前台表单验证码
                String frontCheckCode = req.getParameter("checkCode");
                // 获取后台表单验证码
                String endCheckCode = (String) session.getAttribute("checkCode");
                // 验证码转化小写
                frontCheckCode = frontCheckCode.toLowerCase();
                endCheckCode = endCheckCode.toLowerCase();
                System.out.println("f:" + frontCheckCode + ", e：" + endCheckCode);
                if (frontCheckCode.equals(endCheckCode)) {
                    if (username != null && password != null) {
                        User user = new User(username, password); //封装用户信息
                        //调用控制层类对象的login方法验证用户信息
                        User user_r = userControl.login(user);
                        System.out.println(user_r);
                        //if (user_r!=null && !user_r.equals(null)) {
                        if (user.getPassword().equals(user_r.getPassword())) {
                            User user_ds = userControl.userDetailesSelect(user_r.getUser_id());
                            //将用户信息存储到session中
                            session.setAttribute("user", user_r);
                            session.setAttribute("user_ds", user_ds);
                            res.sendRedirect("index.jsp");

                        } else if (user_r.getUser_id() == 0) {
                            out.println("<script> alert('用户不存在！');location.href='login.jsp';</script>");
                        } else {
                            out.println("<script> alert('密码错误！');location.href='login.jsp';</script>");
                        }
                    } else {
                        out.println("11");
                        out.println("<script> alert('请先登录！');location.href='login.jsp';</script>");
                    }
                } else {
                    out.println("<script> alert('验证码错误！');location.href='login.jsp';</script>");
                }
            } else if (type.equals("register")) {  //判断是否为注册操作
                /**
                 * 用户注册处理操作：
                 * 前端处理：限定格式
                 * 后端处理：1、用户已存在 （数据库表现为字端值不能重复 1062）2、字段数据不符合规定 报错 1406
                 */
                System.out.println("此为注册操作！");
                String email = req.getParameter("email");
                String phone = req.getParameter("tel");
                User user = new User(username, password, email, phone);
                if (1 == userControl.register(user)) {
                    out.println("<script> alert('注册成功！');location.href='login.jsp';</script>");
                } else if (1062 == userControl.register(user)) {
                    out.println("<script> alert('注册失败！用户已存在');location.href='login.jsp';</script>");
                } else
                    out.println("<script> alert('注册失败！');location.href='login.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //设置转发页面的类型和编码方式
            res.setContentType("text/html;charset=utf-8");
            //创建输出对象
            PrintWriter out = res.getWriter();
            out.println("<script> alert('用户不存在0000！');location.href='login.jsp';</script>");
        }

    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
