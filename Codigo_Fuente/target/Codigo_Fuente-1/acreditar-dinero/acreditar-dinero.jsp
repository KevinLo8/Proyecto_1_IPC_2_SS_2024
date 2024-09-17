<%-- 
    Document   : acreditar-dinero
    Created on : 17 sept 2024, 17:08:02
    Author     : kevin
--%>

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
        <div class="section">

            <div class="container offset-4 col-4 text-center">
                <form method="POST" action="${pageContext.servletContext.contextPath}/acreditar-dinero/acreditar-dinero-servlet">
                    <label class="text-info fs-4">Informacion del usuario.</label>
                    <div class="form-group text-start mt-3">
                        <label for="nombreRevista">Nombre del usuario</label>
                        <input type="text" class="form-control" value="${sessionScope.usuario.nombreUsuario}" disabled/>
                        <input type="hidden" class="form-control" name="nombreUsuario" value="${sessionScope.usuario.nombreUsuario}"/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="usuarioRevista">Tipo de usuario</label>
                        <input type="text" class="form-control" value="${sessionScope.usuario.tipoUsuario.name}" disabled/>
                        <input type="hidden" class="form-control" name="tipoUsuario" value="${sessionScope.usuario.tipoUsuario.name}"/>
                    </div>
                    <div class="form-group text-start mt-3">
                        <label for="precio">Credito del usuario</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" on value="${revista.precioRevista}" disabled/>
                        </div>
                    </div>

                    <div class="form-group text-start mt-3">
                        <label for="precio">Cuanto credito quiere agregar</label>
                        <div class="input-group">
                            <span class="input-group-text">Q </span>
                            <input id="precio" name="precio" type="number" min="0.01" step="0.01" 
                                   class="form-control" value="0.00"/>
                        </div>
                    </div>
                    <button class="btn btn-success mt-3">Guardar solicitud</button>
                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>

<script type="text/javascript">
    $("#precio").on("keypress", function () {
        $("#precio").change(function () {
            $(this).val(parseFloat($(this).val()).toFixed(2));
        });
    });
</script>

