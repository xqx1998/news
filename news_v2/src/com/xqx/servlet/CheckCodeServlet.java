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
 * 生成验证码
 */
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 35;
        //1、创建一对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        // 2.1、填充背景色
        Graphics g = image.getGraphics(); //画笔对象
        g.setColor(Color.PINK); //设置画笔颜色
        g.fillRect(0,0,width,height);

        // 2.1、画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random = new Random();
        String checkCode = "";
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            checkCode+=ch;
            g.setFont(new Font(null,Font.ITALIC,height/2+4));
            // 2.3画验证码
            g.drawString(ch+"", width/5*i+20, height/2+5);
        }
        // 创建session对象
        HttpSession session = req.getSession();
        // 将验证码存储到session中
        session.setAttribute("checkCode", checkCode);
        //2.4画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i <15 ; i++) {
            // 随机生成坐标点
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        // 3.将图片输出到页面显示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
