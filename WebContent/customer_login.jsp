<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(msg!=null){%>
	<%=msg %>
	<%} %>
	<form action="AdminServlet" method="post">
		<input type="hidden" name="flag" value="doLogin"/>
		<table>
			<tr>
				<td>账号：</td>
				<td>
					<input type="text" name="name"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="登录"/>
				</td>
				<td>
					<a href="AdminServlet?flag=goRegister">注册</a>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>