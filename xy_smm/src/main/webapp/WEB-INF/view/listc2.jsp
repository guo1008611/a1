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
<script type="text/javascript">


</script>


</head>
<body>

  <div>
  <c:forEach items="${list }" var="b">
    <div style="float: left">
       <div>
       <img alt="未找到图片" src="/file/${b.pic }">
       <br>
       ${b.title} 
       </div>
       
    </div>

  </c:forEach>
    <br>
  </div>
  <div style="clear:both">
      ${page }
  </div>


</body>
</html>