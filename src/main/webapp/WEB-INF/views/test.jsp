<%--
  Created by IntelliJ IDEA.
  User: Dai
  Date: 2016/9/10
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    hello ! <br>
    <c:if test="${not empty contact}">
        ${contact.toString()}
    </c:if>
    <c:if test="${not empty person}">
        ${person.toString()}
    </c:if>
</body>
</html>
