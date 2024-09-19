<%-- 
    Document   : suscripcion-revista
    Created on : 18 sept 2024, 21:55:57
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suscribirse a revista</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="section">
            <div class="container offset-4 col-4 text-center">
                <form method="POST" action="${pageContext.servletContext.contextPath}/suscripcion-revista/suscripcion-revista-servlet">
                    <div class="form-group text-start mt-3">
                        <label for="nombreRevista">Nombre de la revista a la que se va a suscribirse</label>
                        <input type="text" class="form-control" value="${revista.nombreRevista}" disabled/>
                        <input type="hidden" class="form-control" name="nombreRevista" value="${revista.nombreRevista}"/>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="precio">Costo que va a tener la suscripción</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" name="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" value="${revista.precioRevista}" disabled/>
                        </div>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="precio">Credito que se dispone</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" name="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" value="${sessionScope.usuario.credito}" disabled/>
                        </div>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="nombreRevista">Inserte la fecha de la suscripción</label>
                        <input type="date" class="form-control" name="fechaSuscripción" value="${param.fechaSuscripción}" required/>
                    </div>


                    <div class="container text-end mt-3">
                        <c:if test="${usuario.tipoUsuario == 'SUSCRIPTOR'}">
                            <button class="btn btn-success mx-1">Crear suscripcion</button>
                        </c:if>
                        <a href="${pageContext.servletContext.contextPath}/mostrador-revistas/previsualizar-revistas-servlet?nombreRevista=${revista.nombreRevista}"
                           class="btn btn-primary mx-1" type="button">Regresar</a>
                    </div>

                    <p class="text-center fs-2 text-danger mb-5 mt-5">${error}</p>

                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
</html>
