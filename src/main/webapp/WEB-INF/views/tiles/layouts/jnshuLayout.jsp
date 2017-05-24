<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><tiles:getAsString name="title" /></title>
<!-- 这里意思是用tiles中的字符串属性赋予标题  -->

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/Untitled-3.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/Untitled-1base.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/t11.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/base.css' />" rel="stylesheet"></link>
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>