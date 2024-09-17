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
        <jsp:include page="includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
        <div>
            <h1>Listado de Revistas sin Revisar.</h1>
            
            <div class="container">
                <c:forEach items="${revistas}" var="revista">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${revista.nombreRevista}</h5>
                            <p class="card-text">${revista.usuarioPublicador}</p>
                            <p class="card-text">${revista.precioRevista}</p>
                            <a class="card-link" href="">editar precio</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
    </body>
</html>
