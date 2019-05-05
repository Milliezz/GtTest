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
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="flag" value="doDelete" />
	<h1>删除会员信息画面</h1>
	<table>
		<tr>
			<td>编号：</td>
			<td><input type="text" name="id" value="<%=id %>" readonly="readonly" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="" id="" value="删除"/></td>
			<td><a href="CustomerServlet?flag=goIndex">首页</a></td>
		</tr>
	</table>
	</form>
</body>
</html>