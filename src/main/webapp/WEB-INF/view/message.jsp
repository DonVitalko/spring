<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h1>Message from: ${message.from}</h1>
<h1>Message to: ${message.to}</h1>
<h2>Message: ${message.body}</h2>
<br>
<c:url var="deleteUrl" value="/message/delete">
    <c:param name="id" value="${message.id}"/>
</c:url>
<a href="${deleteUrl}">Delete</a>
<br>
<c:url var="editUrl" value="/message/edit">
    <c:param name="id" value="${message.id}"/>
</c:url>
<a href="${editUrl}">Edit</a>
</body>
</html>