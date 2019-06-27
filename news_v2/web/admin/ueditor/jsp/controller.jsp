<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	//获取绝对路径
	String rootPath = application.getRealPath( "/" );
//	System.out.println("1："+rootPath);
	//获取相对路径
	String rootPath1 = request.getContextPath();
//	System.out.println("2: "+rootPath1);
//	System.out.println("3:" + new ActionEnter( request, rootPath ).exec());
//	out.write( new ActionEnter( request, rootPath ).exec() );
	//初始化图片上传组件，获取字符串
	String result = new ActionEnter( request, rootPath ).exec();
	//转换绝对路径的格式为字符串格式
	rootPath = rootPath.replace("\\", "/");
	//替换图片的绝对路径为相对路径
	result = result.replaceAll(rootPath, rootPath1+"/");
//	System.out.println(result);
	//输出到网页
	out.write(result);

%>