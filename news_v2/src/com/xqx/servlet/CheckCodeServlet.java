package com.xqx.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * ������֤��
 */
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 35;
        //1������һ�������ڴ���ͼƬ����֤��ͼƬ����
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.����ͼƬ
        // 2.1����䱳��ɫ
        Graphics g = image.getGraphics(); //���ʶ���
        g.setColor(Color.PINK); //���û�����ɫ
        g.fillRect(0,0,width,height);

        // 2.1�����߿�
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //��������Ǳ�
        Random random = new Random();
        String checkCode = "";
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            checkCode+=ch;
            g.setFont(new Font(null,Font.ITALIC,height/2+4));
            // 2.3����֤��
            g.drawString(ch+"", width/5*i+20, height/2+5);
        }
        // ����session����
        HttpSession session = req.getSession();
        // ����֤��洢��session��
        session.setAttribute("checkCode", checkCode);
        //2.4��������
        g.setColor(Color.GREEN);
        for (int i = 0; i <15 ; i++) {
            // ������������
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        // 3.��ͼƬ�����ҳ����ʾ
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
