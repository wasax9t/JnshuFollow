<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.security.SecureRandom"%>
<%
    SecureRandom random = new SecureRandom();
    random.setSeed(8738);
    double _salt = random.nextDouble();
    session.setAttribute("_salt", _salt);
%>

<div class="login">
	<ul>
		<li>
			<h2>用户登陆</h2>
			<form action="doLogin" method="post">
				用户名：<br /> <input type="text" name="username" /> <br /> 密码：<br />
				<input type="password" name="password" /> <br /> <input
					name="remember-me" type="checkbox" />30天内自动登录 <br /> <input
					type="submit" value="登录" />
			</form>
		</li>
		<li>
			<h2>用户注册</h2>
			<form action="doRegister" method="post">
				<input type="hidden" name="_salt" value="<%=_salt %>" />
				<div><input type="text" name="username" placeholder="请输入用户名"/></div>
				<div><input type="password" name="password" placeholder="请输入密码"/></div>
				<div><input type="text" name="email" placeholder="请输入邮箱"/></div>
				<div><input type="submit" value="注册" /></div>
			</form>
		</li>
	</ul>
</div>

