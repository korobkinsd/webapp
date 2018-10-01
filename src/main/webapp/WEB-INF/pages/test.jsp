<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<spring:form modelAttribute="userForm" method="post" action="">
    <spring:input path="data"/>
    <spring:button>get next birth date</spring:button>
</spring:form>
</body>
</html>
