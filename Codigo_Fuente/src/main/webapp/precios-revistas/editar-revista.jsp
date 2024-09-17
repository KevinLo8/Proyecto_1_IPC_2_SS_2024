<%-- 
    Document   : edicitar-revista
    Created on : 17 sept 2024, 9:59:10
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
                <form method="POST" action="${pageContext.servletContext.contextPath}/precios-revistas/editar-precio-revista-servlet">
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

<script type="text/javascript">
    $("#precio").on("keypress", function () {
        $("#precio").change(function () {
            $(this).val(parseFloat($(this).val()).toFixed(2));
        });
    });
</script>


