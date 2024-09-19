<%-- 
    Document   : reportes-inicio
    Created on : 19 sept 2024, 13:09:58
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
        <c:choose>
            <c:when test="${sessionScope.usuario.tipoUsuario == 'ADMINISTRADOR'}">
                <div class="container">
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de ganancias</a>
                    </div>
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de anuncios</a>
                    </div>
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de 5 revistas mas populares</a>
                    </div>
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de 5 revistas mas comentadas</a>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.usuario.tipoUsuario == 'EDITOR'}">
                <div class="container">
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de comentarios</a>
                    </div>
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}"
                           class="btn btn-primary mx-1" type="button">Reporte de suscripciones</a>
                    </div>
                    <div class="text-center m-3">
                        <a href="${pageContext.servletContext.contextPath}/reportes/reporte-5-mas-gustados-servlet"
                           class="btn btn-primary mx-1" type="button">Reporte de 5 revistas mas gustados</a>
                    </div>
                </div>
            </c:when>
        </c:choose>
        <jsp:include page="../includes/footer.jsp"/>
</html>
