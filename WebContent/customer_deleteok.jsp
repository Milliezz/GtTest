<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String id=(String)request.getAttribute("id"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>删除成功</h1>
	<h3>删除的信息如下：</h3>
	<table>
		<tr>
			<td>编号：</td>
			<td><%=id %></td>
		</tr>
	</table>
	<hr />
	<h3>跳转到<a href="CustomerServlet?flag=goIndex">首页</a></h3>
</body>
</html>