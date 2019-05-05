<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CustomerServlet" method="post">
		<input type="hidden" name="flag" value="doInsert"/>
		<table>
			<tr>
				<td>编号：</td>
				<td>
					<input type="text" name="id"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>名字：</td>
				<td>
					<input type="text" name="name"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>积分：</td>
				<td>
					<input type="text" name="points"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>
					<input type="text" name="tel"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" value="男"/>男
					<input type="radio" name="sex" value="女"/>女
					<!-- 单选按钮传值，必须指定value -->
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="添加"/>
				</td>
				<td>
					<a href="CustomerServlet?flag=goIndex">首页</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>