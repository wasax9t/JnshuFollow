<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="login">
    <h2>登陆成功,User: ${user.name}</h2>
    welcome to user home page!<br/>
    告诉你一个秘密，下面一丢丢还有一个看不到的退出登陆的按钮，因为这个css下字是白的，而我不会css<br/>
    好消息，我新建了一个css的class选择器，指定了a的颜色，不居中了？who cares<br/>
    <a href="${pageContext.request.contextPath}/logout">退出登录</a>

</div>
