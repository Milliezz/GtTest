<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td input[type=submit]{
	background-color: rgb(0,245,255);
	}
</style>
</head>
<body>
	<%if(msg!=null){%>
	<%=msg %>
	<%} %>

	<form action="CustomerRegisterServlet" method="post">
	<input type="hidden" name="flag" value="doRegister">
		<h1>注册画面</h1>
		<table>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" name="no" placeholder="11位号码" /></td>
				<td style="color:red;">*请输入11位手机号码</td>
			</tr>
	
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pw" placeholder="6位密码" /></td>
				<td style="color:red;">*请输入6位密码</td>
			</tr>
			
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="conpw" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="checkbox" />同意xxx协议</td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="注册" /></td>
				<td><a href="CustomerRegisterServlet?flag=goLogin">登录</a></td>
			</tr>
		</table>
		
			
	</form>

</body>
</html>