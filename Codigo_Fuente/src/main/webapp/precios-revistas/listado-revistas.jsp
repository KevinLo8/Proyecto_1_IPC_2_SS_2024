<%-- 
    Document   : revisar-revistas.jsp
    Created on : 16 sept 2024, 17:44:25
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Revistas</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <h1 class="text-body-emphasis">Listado de Revistas.</h1>

            <c:forEach items="${revistas}" var="revista">
                <div class="container my-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${revista.nombreRevista}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${revista.usuarioPublicador}</h6>
                            <p class="card-text loan-input">${revista.precioRevista}</p>
                            <a href="${pageContext.servletContext.contextPath}/precios-revistas/editar-precio-revista-servlet?nombre=${revista.nombreRevista}"
                               class="card-link">editar precio</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
