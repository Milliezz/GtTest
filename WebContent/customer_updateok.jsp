<%@page import="com.asjy.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<% Customer customer=(Customer)request.getAttribute("customer"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>修改成功</h1>
	<h3>修改的信息如下：</h3>
	<table>
		<tr>
			<td>编号：</td>
			<td>
				<%=customer.getId() %>
			</td>
		</tr>
		<tr>
			<td>名字：</td>
			<td>
				<%=customer.getName() %>
			</td>
		</tr>
		<tr>
			<td>积分：</td>
			<td>
				<%=customer.getPoints() %>
			</td>
		</tr>
		<tr>
			<td>电话：</td>
			<td>
				<%=customer.getTel() %>
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<%=customer.getSex() %>
			</td>
		</tr>
	</table>
	<hr />
	<h3>跳转到<a href="CustomerServlet?flag=goIndex">首页</a></h3>
</body>
</html>