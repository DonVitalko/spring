<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product list</h1>
<ul>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${products}">
        <c:url var="viewUrl" value="/product/ + ${product.id}">
        </c:url>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Id: ${product.id}
            <br>
            Title: ${product.title}
            <br>
            Cost: ${product.cost}
            <br>
        </li>
    </c:forEach>
</ul>
<c:url var="createUrl" value="/product/create">
</c:url>
<a href="${createUrl}">Create</a>
</body>
</html>