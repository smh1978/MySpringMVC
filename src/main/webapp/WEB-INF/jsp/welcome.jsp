<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>welcome</title>
</head>
<body>
<table>
<c:forEach items="${mList}" var="mobile">
	<tr><td>${mobile.tradeMark }</td><td>${mobile.price }</td><tr>
</c:forEach>
</table>

</body>
</html>