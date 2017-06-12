<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="/ELFunction" prefix="fn" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ System.currentTimeMillis() }" var="ms"></c:set>
<div><c:out value="${fn:msToDate(ms)}">coutdefault</c:out></div>