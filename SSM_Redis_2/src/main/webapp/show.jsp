<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<title>显示页面</title>
</head>
<body>

	<a href="add.jsp">添加用户</a>			<a href="exit">退出</a> 
	<table id="tab" border="1px">
		<tr>
		<td>Id</td>
		<td>姓名</td>
		<td>密码</td>
		<td>操作</td>
		</tr>
		
	
		<c:forEach items="${list}" var="i">
		
		<tr>
		<td>${i.id}</td>
		<td>${i.name}</td>
		<td>${i.password}</td>
		<td>
		<a href="Byid?id=${i.id}">✏</a>
		<a href="delete?id=${i.id}">❎</a>
		</td>
		</tr>
		</c:forEach>
			</table>
	
		
		
	
	
</body>
</html>