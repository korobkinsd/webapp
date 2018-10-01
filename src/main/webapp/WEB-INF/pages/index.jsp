<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<header>
</header>
<body>

<div id="header">
    <jsp:include page="header.jsp"/>
</div>

<form:form method="POST" action="/index/check" modelAttribute="userForm">
    <form:input title="Date birth"  path="name" type="date"/>

    <input type="submit" name="complete" value="Submit"/>
</form:form>
<br>



<div id="footer">
    <jsp:include page="footer.jsp"/>
</div>

</body>
</html>


