<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="login">
    <h2>${status}, ${username}</h2>
    你现在可以：<br/>
    <a href="${pageContext.request.contextPath}/login">去tm登录界面重新输一遍账密</a>

</div>
</body>
</html>