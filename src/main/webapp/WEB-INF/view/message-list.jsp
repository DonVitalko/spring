<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<h1>Message List</h1>
<ul>
    <jsp:useBean id="messages" scope="request" type="java.util.List"/>
    <c:forEach var="message" items="${messages}">
        <c:url var="viewUrl" value="/message/ + ${message.id}">
        </c:url>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Message from: ${message.from}
            <br>
            Message to: ${message.to}
            <br>
            Message: ${message.body}
            <br>
        </li>
    </c:forEach>
</ul>
<c:url var="createUrl" value="/message/create">
</c:url>
<a href="${createUrl}">Create</a>
</body>
</html>