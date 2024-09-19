<%-- 
    Document   : perfil-usuario
    Created on : 19 sept 2024, 0:39:17
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="section">
            <div class="container offset-4 col-4 text-center">
                <form method="POST" action="${pageContext.servletContext.contextPath}/precios-revistas/editar-precio-revista-servlet">
                    <div class="form-group text-start mt-3">
                        <label for="nombreRevista">Nombre de usuario</label>
                        <input type="text" class="form-control" value="${sessionScope.usuario.nombreUsuario}" disabled/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Fecha de creacion</label>
                        <input type="date" class="form-control" value="${sessionScope.usuario.fechaCreacion}" disabled/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Tipo de usuario</label>
                        <input type="text" class="form-control" value="${sessionScope.usuario.tipoUsuario}" disabled/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Credito disponible</label>
                        <input type="number" class="form-control" value="${sessionScope.usuario.credito}" disabled/>

                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="precio">Precio de la suscripción:</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" name="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" value="${revista.precioRevista}"/>
                        </div>
                    </div>
                    <button class="btn btn-success mt-3">Guardar solicitud</button>
                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
