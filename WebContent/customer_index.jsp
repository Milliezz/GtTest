<%@page import="com.asjy.model.Admin"%>
<%@page import="com.asjy.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")   // 取消警告
	List<Customer> cusList = (List<Customer>)request.getAttribute("cusList");
    Admin admin=(Admin)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎您：<%=admin.getName() %>
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="flag" value="doSearch" />
		<table>
			<tr>
				<td>编号：</td>
				<td>
					<input type="text" name="id"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td>
					<input type="text" name="tel"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="搜索"/>
				</td>
				<td>
					<a href="CustomerServlet?flag=goInsert">添加</a>
				</td>
			</tr>
		</table>
	</form>
	<% if(cusList.size()>0&&cusList!=null){%>
	共计 - <%=cusList.size() %>条 -
	<table border="1 solid;" cellspacing="0">
		<tr>
			<td>#</td>
			<td>编号</td>
			<td>名字</td>
			<td>积分</td>
			<td>手机号</td>
			<td>性别</td>
			<td>操作</td>
		</tr>
		
		<% 
			int count = 0;
			
				for (Customer customer : cusList){ 
					count++;
		%>
		
		
			<tr>
				<td><%=count %></td>
				<td><%=customer.getId() %></td>
				<td><%=customer.getName() %></td>
				<td><%=customer.getPoints() %></td>
				<td><%=customer.getTel() %></td>
				<td><%=customer.getSex() %></td>
				<td>
					<a href="CustomerServlet?flag=goUpdate&id=<%=customer.getId() %>">修改</a>
					<a href="CustomerServlet?flag=goDelete&id=<%=customer.getId() %>">删除</a>
				</td>
			</tr>
		<% 		}	
			} 
			else{
		%>
				<span>抱歉，没有商品信息</span>
		<%
			}
		%>
		
	</table>
</body>
</html>