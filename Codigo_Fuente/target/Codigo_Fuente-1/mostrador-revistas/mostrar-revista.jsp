<%-- 
    Document   : mostrar-revista
    Created on : 17 sept 2024, 23:02:38
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <h1 class="text-body-emphasis text-center">${revista.nombreRevista}.</h1>

            <div class="container text-end">
                <a class="btn btn-primary m-1" type="button">Descargar</a>
                <a href="${pageContext.servletContext.contextPath}/mostrador-revistas/mostrador-revistas-servlet"
                   class="btn btn-primary m-1" type="button">Regresar</a>
            </div>
            <div class="container">
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
