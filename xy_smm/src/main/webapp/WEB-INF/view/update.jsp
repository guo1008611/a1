<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resource/css/index1.css">
<title>Insert title here</title>
<script type="text/javascript"  src="/resource/js/jquery-1.8.2.min.js"></script>
</head>
<body>


	<form action="">
			<table>
				<tr> <td>序号<input type="text" name="id" value="${s.id }" id=""> <td></tr>
				<tr> <td>姓名<input type="text" name="name" id="" value="${s.name }"> <td></tr>
				<tr> <td>性别<input type="text" name="sex" id=""value="${s.sex }"> <td></tr>
				<tr> <td>年龄<input type="text" name="birthday" id="" value="${s.birthday }"> <td></tr>
				<tr> <td>爱好<input type="text" name="hobby" id="" value="${s.hobby }"> <td></tr>
				<tr> <td> <input type="button" value="提交" onclick="tj()"> <td></tr>
			</table>
	
	</form>
	<script type="text/javascript">
		function tj(){
			$.post("update",$("form").serialize(),function(i){
				if(i){
					alert("成功");
					location="list";
				}else{
				alert("失败");
				location="err";
				}
				
			},"json");
		}
	</script>
</body>
</html>