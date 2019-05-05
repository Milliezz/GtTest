<%@page import="com.asjy.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Customer customer = (Customer)request.getAttribute("customer");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	添加成功！
	添加信息如下：
	<br>
	编号：<%=customer.getId() %>
	<br>
	姓名：<%=customer.getName() %>
	<br>
	积分：<%=customer.getPoints() %>
	<br>
	电话：<%=customer.getTel() %>
	<br>
	性别：<%=customer.getSex() %>
	<hr />
	<div>继续<a href="CustomerServlet?flag=goInsert">添加</a>下一个会员的信息</div>
	<div>跳转到<a href="CustomerServlet?flag=goIndex">首页</a></div>
</body>
</html>