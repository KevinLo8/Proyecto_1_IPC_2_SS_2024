<%-- 
    Document   : revistas-suscritas
    Created on : 19 sept 2024, 1:33:26
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revistas suscritas</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <h1 class="text-body-emphasis">Listado de Suscripciones.</h1>

            <c:forEach items="${suscripciones}" var="suscripcion">
                <div class="container my-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title my-2 text-info">Nombre de la revista suscrita</h5>
                            <h6 class="card-subtitle my-2 text-body-secondary">${suscripcion.nombreRevista}</h6>
                            <h6 class="card-subtitle my-2 text-info">Fechas que se suscribio</h6>
                            <p class="card-text my-2 loan-input">${suscripcion.fechaSuscripcion}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
</html>
