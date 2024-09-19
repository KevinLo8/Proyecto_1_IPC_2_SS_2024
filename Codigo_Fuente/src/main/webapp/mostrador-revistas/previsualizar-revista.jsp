<%-- 
    Document   : previsualizar-revista
    Created on : 18 sept 2024, 19:57:25
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Previsualizar revista</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="section">
            <div class="container offset-4 col-4 text-center">
                <form>
                    <div class="form-group text-start mt-3">
                        <label for="nombreRevista">Nombre de la revista</label>
                        <input type="text" class="form-control" value="${revista.nombreRevista}" disabled/>
                        <input type="hidden" class="form-control" name="nombreRevista" value="${revista.nombreRevista}"/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Usuario que publico la revista</label>
                        <input type="text" class="form-control" value="${revista.usuarioPublicador}" disabled/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="descripción"">Descripción</label>
                        <textarea class="form-control" name="descripción" rows="4" disabled>${revista.descripcion}</textarea>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Revista que se subio</label>
                        <input type="text" class="form-control" value="${revista.nombreArchivo}" disabled/>
                        <input type="hidden" name="archivoRevista" value="${revista.archivoRevista}"/>
                        <input type="hidden" name="nombreArchivo" value="${revista.nombreArchivo}"/>
                        <input type="hidden" name="extencionArchivo" value="${revista.extencionArchivo}"/>

                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="precio">Precio de la suscripción:</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" name="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" value="${revista.precioRevista}" disabled/>
                        </div>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Credito disponible</label>
                        <div class="input-group">
                            <span class="input-group-text">Cantidad de "Me Gusta"</span>
                            <input id="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" on value="${revista.cantidadMeGusta}" disabled/>
                        </div>

                    </div>


                    <div class="container text-end mt-3">
                        <c:if test="${usuario.tipoUsuario == 'SUSCRIPTOR'}">
                            <a href="${pageContext.servletContext.contextPath}/suscripcion-revista/suscripcion-revista-servlet?nombreRevista=${revista.nombreRevista}"
                               class="btn btn-success mx-1">Suscribirse</a>
                        </c:if>
                        <a href="${pageContext.servletContext.contextPath}/mostrador-revistas/mostrador-revistas-servlet"
                           class="btn btn-primary mx-1" type="button">Regresar</a>
                    </div>

                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
</html>
