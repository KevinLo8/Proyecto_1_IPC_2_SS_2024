<%-- 
    Document   : mostrador-revistas
    Created on : 17 sept 2024, 19:05:11
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revistas</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <h1 class="text-body-emphasis text-center">Listado de Revistas.</h1>

            <div class="container">
                <c:forEach items="${revistas}" var="revista">
                    <c:if test="${revista.precioRevista != 0}">
                        <div class="card m-4">
                            <div class="card-body">
                                <form method="POST" action="${pageContext.servletContext.contextPath}/mostrador-revistas/mostrador-revistas-servlet">
                                    <input type="hidden" class="form-control" name="nombreRevista" value="${revista.nombreRevista}"/>
                                    <h5 class="card-title">${revista.nombreRevista}</h5>
                                    <h6 class="card-subtitle mb-2 text-body-secondary">${revista.usuarioPublicador}</h6>
                                    <p class="card-text loan-input">Q&ensp;${revista.precioRevista}</p>
                                    <p class="card-text loan-input">Categoria:&ensp;${revista.categoria}</p>
                                    <div class="input-group">
                                        <label class="text">Tags:&ensp;</label>
                                        <c:forEach items="${revista.tags}" var="tag">
                                            <label class="text">${tag},&ensp;</label>
                                        </c:forEach>
                                    </div>
                                    
                                    <div class="my-3">
                                        <c:choose>
                                            <c:when test="${revista.suscrito == true}">
                                                <button type="summit" class="btn btn-primary">Visualizar</button>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${pageContext.servletContext.contextPath}/mostrador-revistas/previsualizar-revistas-servlet?nombreRevista=${revista.nombreRevista}" 
                                                   type="button" class="btn btn-secondary">Previsualizar</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
