package com.xqx.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xqx.control.UserControl;
import com.xqx.model.User;
import com.xqx.service.UserService;
import com.xqx.service.impl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAction extends ActionSupport implements ServletRequestAware {
    UserService userService = new UserServiceImpl();
    private HttpServletRequest request;
    private String username;
    private String password;
    private String checkCode;
    private String email;
    private String tel;
    private String result;
    private UserControl userControl = new UserControl();

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toLogin() {
        return "toLogin";
    }

    public String toRegister() {
        return "toRegister";
    }
    public String toIndex(){
        return "toIndex";
    }
    public String login() {
        System.out.println(username);
        /**
         * 登录处理操作会会出现的情况
         * 前端处理：限定格式
         * 后端处理：1、用户不存在 2、密码错误 3、验证通过
         */
        //创建session对象
        HttpSession session = request.getSession();

        // 获取后台表单验证码
        String endCheckCode = (String) session.getAttribute("checkCode");
        System.out.println("endCheckCode:" + endCheckCode);
        // 验证码转化小写
        checkCode = checkCode.toLowerCase();

        endCheckCode = endCheckCode.toLowerCase();
        System.out.println("f:" + checkCode + ", e：" + endCheckCode);
        if (checkCode.equals(endCheckCode)) {
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
                    session.setAttribute("loginResult", "1");
                    return "toIndex";
                } else if (user_r.getUser_id() == 0) {
                    session.setAttribute("loginResult", "用户不存在！");
                } else {
                    session.setAttribute("loginResult", "密码错误！");
                }
            } else {
                session.setAttribute("loginResult", "用户名或密码不能为空！");
            }
        } else {
            session.setAttribute("loginResult", "验证码错误！");
        }
        return "toLogin";
    }

   public String register() {
       System.out.println(username);
       /**
        * 用户注册处理操作：
        * 前端处理：限定格式
        * 后端处理：1、用户已存在 （数据库表现为字端值不能重复 1062）2、字段数据不符合规定 报错 1406
        */
       //创建session对象
       HttpSession session = request.getSession();
       // 获取后台表单验证码
       String endCheckCode = (String) session.getAttribute("checkCode");
       System.out.println("endCheckCode:" + endCheckCode);
       // 验证码转化小写
       checkCode = checkCode.toLowerCase();

       endCheckCode = endCheckCode.toLowerCase();
       System.out.println("f:" + checkCode + ", e：" + endCheckCode);
       if (checkCode.equals(endCheckCode)) {
           if (username != null && password != null) {
               User user = new User(username, password, email, tel); //封装用户信息
               int code = userControl.register(user);
               if (1 == code) {
                   // out.println("<script> alert('注册成功！');location.href='login.jsp';</script>");
                    session.setAttribute("registerResult", "1");
               } else if (1062 == code) {
                   // out.println("<script> alert('注册失败！用户已存在');location.href='login.jsp';</script>");
                   session.setAttribute("registerResult", "注册失败！用户已存在");
               } else {
                   // out.println("<script> alert('注册失败！');location.href='login.jsp';</script>");
                   session.setAttribute("registerResult", "注册失败！");
               }
           }
       }
       return "toRegister";
   }
}