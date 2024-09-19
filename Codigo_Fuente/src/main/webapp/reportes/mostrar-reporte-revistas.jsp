<%-- 
    Document   : mostrar-reporte-revistas
    Created on : 19 sept 2024, 13:26:09
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
            <h1 class="text-body-emphasis">Listado de Suscripciones.</h1>

            <c:forEach items="${suscripciones}" var="suscripcion">
                <div class="container my-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title my-2 text-info">Nombre de la revista</h5>
                            <h6 class="card-subtitle my-2 text-body-secondary">${revista.nombreRevista}</h6>
                            <h6 class="card-subtitle my-2 text-info">Ususiro que la publico</h6>
                            <p class="card-text my-2 loan-input">${revista.usuarioPublicador}</p>
                            <h6 class="card-subtitle my-2 text-info">Descripción</h6>
                            <textarea class="card-text my-2 loan-input" rows="4" disabled>${revista.descripcion}</textarea>
                            <h6 class="card-subtitle my-2 text-info">Precio</h6>
                            <input type="number" class="card-text my-2 loan-input" value="${revista.precioRevista}" disabled/>
                            <h6 class="card-subtitle my-2 text-info">Nombre de archivo</h6>
                            <p class="card-text my-2 loan-input">${revista.nombreArchivo}</p>
                            <h6 class="card-subtitle my-2 text-info">cantidad de "Me Gusta"</h6>
                            <input type="number" class="card-text my-2 loan-input" value="${revista.cantidadMeGusta}" disabled/>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
