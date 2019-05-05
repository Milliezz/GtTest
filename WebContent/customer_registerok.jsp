<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.asjy.model.Register"%>
    <%Register register=(Register)request.getAttribute("register"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册成功</h1>
	<!-- 接收值 -->
	<h3>手机号为：<%=register.getNo()%></h3>
	<h3>跳转到<a href="CustomerRegisterServlet?flag=goLogin">登录</a>画面</h3>
	
	
</body>
</html>