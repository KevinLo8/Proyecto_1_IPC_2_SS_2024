<%-- 
    Document   : log_in
    Created on : 11 sept 2024, 17:13:37
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="${pageContext.servletContext.contextPath}/includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="${pageContext.servletContext.contextPath}/includes/header.jsp"/>
        <h1>Hello World!</h1>
        <jsp:include page="${pageContext.servletContext.contextPath}/includes/footer.jsp"/>
    </body>
</html>
