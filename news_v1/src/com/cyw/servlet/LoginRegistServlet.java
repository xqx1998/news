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
 * @Description�� �û���¼ע�ᴦ��
 */
public class LoginRegistServlet extends HttpServlet {
    UserControl userControl = new UserControl();

    public void init() throws ServletException {
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {

            req.setCharacterEncoding("utf-8");  //���ý������ݵı��뷽ʽ
            res.setCharacterEncoding("utf-8");  //���÷������ݵı��뷽ʽ
            String username = req.getParameter("username");  //��ȡlogin_register.jsp���ύ��usernameֵ
            System.out.println("username:" + username);
            String password = req.getParameter("password");
            System.out.println(username + "," + password);
            String type = req.getParameter("type"); //��ȡlogin_register.jsp���ύ��typeֵ
            System.out.println("type:" + type);
            //����ת��ҳ������ͺͱ��뷽ʽ
            res.setContentType("text/html;charset=utf-8");
            //�����������
            PrintWriter out = res.getWriter();
            //����ҳ���������
            //�ж��Ƿ�Ϊ��¼����
            if (type.equals("login")) {
                /**
                 * ��¼������������ֵ����
                 * ǰ�˴����޶���ʽ
                 * ��˴���1���û������� 2��������� 3����֤ͨ��
                 */
                //����session����
                HttpSession session = req.getSession();
                //��ȡǰ̨����֤��
                String frontCheckCode = req.getParameter("checkCode");
                // ��ȡ��̨����֤��
                String endCheckCode = (String) session.getAttribute("checkCode");
                // ��֤��ת��Сд
                frontCheckCode = frontCheckCode.toLowerCase();
                endCheckCode = endCheckCode.toLowerCase();
                System.out.println("f:" + frontCheckCode + ", e��" + endCheckCode);
                if (frontCheckCode.equals(endCheckCode)) {
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
                            res.sendRedirect("index.jsp");

                        } else if (user_r.getUser_id() == 0) {
                            out.println("<script> alert('�û������ڣ�');location.href='login.jsp';</script>");
                        } else {
                            out.println("<script> alert('�������');location.href='login.jsp';</script>");
                        }
                    } else {
                        out.println("11");
                        out.println("<script> alert('���ȵ�¼��');location.href='login.jsp';</script>");
                    }
                } else {
                    out.println("<script> alert('��֤�����');location.href='login.jsp';</script>");
                }
            } else if (type.equals("register")) {  //�ж��Ƿ�Ϊע�����
                /**
                 * �û�ע�ᴦ�������
                 * ǰ�˴����޶���ʽ
                 * ��˴���1���û��Ѵ��� �����ݿ����Ϊ�ֶ�ֵ�����ظ� 1062��2���ֶ����ݲ����Ϲ涨 ���� 1406
                 */
                System.out.println("��Ϊע�������");
                String email = req.getParameter("email");
                String phone = req.getParameter("tel");
                User user = new User(username, password, email, phone);
                if (1 == userControl.register(user)) {
                    out.println("<script> alert('ע��ɹ���');location.href='login.jsp';</script>");
                } else if (1062 == userControl.register(user)) {
                    out.println("<script> alert('ע��ʧ�ܣ��û��Ѵ���');location.href='login.jsp';</script>");
                } else
                    out.println("<script> alert('ע��ʧ�ܣ�');location.href='login.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //����ת��ҳ������ͺͱ��뷽ʽ
            res.setContentType("text/html;charset=utf-8");
            //�����������
            PrintWriter out = res.getWriter();
            out.println("<script> alert('�û�������0000��');location.href='login.jsp';</script>");
        }

    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
