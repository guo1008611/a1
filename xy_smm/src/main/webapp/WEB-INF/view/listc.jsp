<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resource/css/index2.css">
<title>Insert title here</title>
<script type="text/javascript"  src="<%=request.getContextPath() %>/jquery/jquery-1.8.2.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>爱好</td>
			<td>生日</td>
			<td>头像</td>
			<td>操作|<a href="toadd">添加</a></td>
		</tr>
		<c:forEach items="${list }" var="a">
				<tr>
					<td>${a.id }</td>
					<td>${a.name }</td>
					<td>${a.sex }</td>
					<td>${a.hobby }</td>
					<td>${a.birthday }</td>
					<td><img alt="c" src="/file/${a.pic }">
					
					</td>
					<td><a href="updateid?id=${a.id }">修改</a>
						<a href="delid?id=${a.id }">删除</a>
						</td>
				</tr>
		
		</c:forEach>
		<tr>
			<td colspan="10">${fenye }</td>
		</tr>
	</table>
</body>
</html>