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
                <form method="POST" action="${pageContext.servletContext.contextPath}/perfil-usuario/perfil-usuario-servlet">
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
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" on value="${sessionScope.usuario.credito}" disabled/>
                        </div>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="descripción"">Hobbies</label>
                        <textarea class="form-control" name="hobbies" rows="4">${sessionScope.usuario.hobbies}</textarea>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="descripción"">Temas de Interés</label>
                        <textarea class="form-control" name="temasInteres" rows="4">${sessionScope.usuario.temasInteres}</textarea>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="descripción"">Descripción</label>
                        <textarea class="form-control" name="descripción" rows="4">${sessionScope.usuario.descripcion}</textarea>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="descripción"">Gustos</label>
                        <textarea class="form-control" name="gustos" rows="4">${sessionScope.usuario.gustos}</textarea>
                    </div>

                    <button class="btn btn-success mt-3">Guardar datos de perfil</button>

                    <p class="text-center fs-2 text-info mb-5 mt-5">${completo}</p>
                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
