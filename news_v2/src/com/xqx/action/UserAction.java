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
         * ��¼������������ֵ����
         * ǰ�˴����޶���ʽ
         * ��˴���1���û������� 2��������� 3����֤ͨ��
         */
        //����session����
        HttpSession session = request.getSession();

        // ��ȡ��̨����֤��
        String endCheckCode = (String) session.getAttribute("checkCode");
        System.out.println("endCheckCode:" + endCheckCode);
        // ��֤��ת��Сд
        checkCode = checkCode.toLowerCase();

        endCheckCode = endCheckCode.toLowerCase();
        System.out.println("f:" + checkCode + ", e��" + endCheckCode);
        if (checkCode.equals(endCheckCode)) {
            if (username != null && password != null) {
                User user = new User(username, password); //��װ�û���Ϣ
                //���ÿ��Ʋ�������login������֤�û���Ϣ
                User user_r = userControl.login(user);
                System.out.println(user_r);
                //if (user_r!=null && !user_r.equals(null)) {
                if (user.getPassword().equals(user_r.getPassword())) {
                    User user_ds = userControl.userDetailesSelect(user_r.getUser_id());
                    //���û���Ϣ�洢��session��
                    session.setAttribute("user", user_r);
                    session.setAttribute("user_ds", user_ds);
                    session.setAttribute("loginResult", "1");
                    return "toIndex";
                } else if (user_r.getUser_id() == 0) {
                    session.setAttribute("loginResult", "�û������ڣ�");
                } else {
                    session.setAttribute("loginResult", "�������");
                }
            } else {
                session.setAttribute("loginResult", "�û��������벻��Ϊ�գ�");
            }
        } else {
            session.setAttribute("loginResult", "��֤�����");
        }
        return "toLogin";
    }

   public String register() {
       System.out.println(username);
       /**
        * �û�ע�ᴦ�������
        * ǰ�˴����޶���ʽ
        * ��˴���1���û��Ѵ��� �����ݿ����Ϊ�ֶ�ֵ�����ظ� 1062��2���ֶ����ݲ����Ϲ涨 ���� 1406
        */
       //����session����
       HttpSession session = request.getSession();
       // ��ȡ��̨����֤��
       String endCheckCode = (String) session.getAttribute("checkCode");
       System.out.println("endCheckCode:" + endCheckCode);
       // ��֤��ת��Сд
       checkCode = checkCode.toLowerCase();

       endCheckCode = endCheckCode.toLowerCase();
       System.out.println("f:" + checkCode + ", e��" + endCheckCode);
       if (checkCode.equals(endCheckCode)) {
           if (username != null && password != null) {
               User user = new User(username, password, email, tel); //��װ�û���Ϣ
               int code = userControl.register(user);
               if (1 == code) {
                   // out.println("<script> alert('ע��ɹ���');location.href='login.jsp';</script>");
                    session.setAttribute("registerResult", "1");
               } else if (1062 == code) {
                   // out.println("<script> alert('ע��ʧ�ܣ��û��Ѵ���');location.href='login.jsp';</script>");
                   session.setAttribute("registerResult", "ע��ʧ�ܣ��û��Ѵ���");
               } else {
                   // out.println("<script> alert('ע��ʧ�ܣ�');location.href='login.jsp';</script>");
                   session.setAttribute("registerResult", "ע��ʧ�ܣ�");
               }
           }
       }
       return "toRegister";
   }
}