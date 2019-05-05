<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id=(int)request.getAttribute("id");
	String name=(String)request.getAttribute("name");
	double points=(double)request.getAttribute("points");
	String tel=(String)request.getAttribute("tel");
	String sex=(String)request.getAttribute("sex");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="flag" value="doUpdate" />
		<h1>修改会员信息画面</h1>
		<table>
			<tr>
				<td>会员编号</td>
				<td>
					<input type="text" name="id" id="" value="<%=id%>" readonly="readonly"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>名字</td>
				<td>
					<input type="text" name="name" id="" value="<%=name%>" />
				</td>
				<td style="color:red;">*请输入正确的名字</td>
			</tr>
			<tr>
				<td>积分</td>
				<td>
					<input type="text" name="points" id="" value="<%=points%>" />
				</td>
				<td style="color:red;">*请输入数字</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>
					<input type="text" name="tel" id="" value="<%=tel%>" />
				</td>
				<td style="color:red;">*请输入11位手机号</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					
					<input type="radio" name="sex" id="" value="男" 
						<%if("男".equals(sex)){ %>
							checked="checked"
						<%} %>
					 />男
					 <!-- 如果传过来的参数值为男，则默认选中男的单选按钮 -->
					
					<input type="radio" name="sex" id="" value="女" 
						<%if("女".equals(sex)){ %>
							checked="checked"
						<%} %>
					 />女
					 <!-- 如果传过来的参数值为女，则默认选中女的单选按钮 -->
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" name="" id="" value="修改"/>
				</td>
				<td><a href="CustomerServlet?flag=goIndex">首页</a></td>
			</tr>
		</table>
	</form>
</body>
</html>