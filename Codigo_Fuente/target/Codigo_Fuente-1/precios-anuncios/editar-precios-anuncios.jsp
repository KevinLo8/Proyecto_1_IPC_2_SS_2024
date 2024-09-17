<%-- 
    Document   : editar-precios-anuncios
    Created on : 16 sept 2024, 17:43:20
    Author     : kevin
--%>

<%@page import="com.main.codigo_fuente.app.backend.precios_anuncios.PreciosAnuncios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevos Precios Anuncios</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Crear Nuevos Precios Para Los Anuncios</h1>

                <div class="mt-4">
                    <label class="fs-3">
                        Precios Actuales
                    </label>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Nombre tipo</th>
                                <th scope="col">Cantidad Precio</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <th scope="col">Anuncio de texto</th>
                                <th scope="col">${precios.precioTexto}</th>
                            </tr>
                            <tr>
                                <th scope="col">Anuncio de texto e imagen</th>
                                <th scope="col">${precios.precioTextoEImagen}</th>
                            </tr>
                            <tr>
                                <th scope="col">Anuncio de video</th>
                                <th scope="col">${precios.precioVideo}</th>
                            </tr>
                            <tr>
                                <th scope="col">Duración de 1 dia</th>
                                <th scope="col">${precios.precio1Dia}</th>
                            </tr>
                            <tr>
                                <th scope="col">Duración de 3 dias</th>
                                <th scope="col">${precios.precio3Dias}</th>
                            </tr>
                            <tr>
                                <th scope="col">Duración de 1 semana</th>
                                <th scope="col">${precios.precio1Semana}</th>
                            </tr>
                            <tr>
                                <th scope="col">Duración de 2 semanas</th>
                                <th scope="col">${precios.precio2Semanas}</th>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <form method="POST" action="${pageContext.servletContext.contextPath}/precios-anuncios/crear-edicion-precios-servlet">
                    <label class="fs-3 mt-5">
                        Nuevos Precios
                    </label>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >Precio anuncio de texto</span>
                        <input type="number" class="form-control dinero" name="precioTexto" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio anuncio de texto e imagen</span>
                        <input type="number" class="form-control dinero" name="precioTextoEImagen" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio anuncio de video</span>
                        <input type="number" class="form-control dinero" name="precioVideo" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio duración de 1 dia</span>
                        <input type="number" class="form-control dinero" name="precio1Dia" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio duración de 3 dias</span>
                        <input type="number" class="form-control dinero" name="precio3Dias" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio duración de 1 semana</span>
                        <input type="number" class="form-control dinero" name="precio1Semana" value="0.00" min="0.01" step="0.01">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Precio duración de 2 semanas</span>
                        <input type="number" class="form-control dinero" name="precio2Semanas" value="0.00" min="0.01" step="0.01">
                    </div>

                    <div class="input-group mb-5">
                        <button  class="btn btn-primary btn-lg active" role="button" >Crear Nuevos Precios</button>
                    </div>

                    <p class="text-center fs-2 text-danger mb-5 mt-5">${error}</p>

                </form>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>

<script type="text/javascript">
    $(document).on("keypress", function () {
        $(".dinero").change(function () {
            $(this).val(parseFloat($(this).val()).toFixed(2));
        });
    });
</script>
