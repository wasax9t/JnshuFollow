<%@page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align="left">
	<h2>用户登陆</h2>
	<form action="check" method="post">
		用户名：<br> 
		<input type="text" name="username" /> <br>
		密码：<br> 
		<input type="password" name="password" /> <br>
		<input name="remember-me" type="checkbox">30天内自动登录</input> <br>
		<input type="submit" value="登录" />

	</form>

</div>