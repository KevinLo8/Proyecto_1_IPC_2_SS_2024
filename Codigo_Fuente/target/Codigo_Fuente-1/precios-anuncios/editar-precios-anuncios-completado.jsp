<%-- 
    Document   : CompraAnuncioCompletado
    Created on : 15 sept 2024, 16:42:09
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edición Completa</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Edición de Precios Completado</h1>
                <p class="col-lg-6 mx-auto mb-4">
                    Se ha completado y guardado los nuevos preciós de anuncios correctamente.
                </p>
                <button class="btn btn-primary px-5 mb-5" type="button"
                        onclick="javascript:window.location = '${pageContext.servletContext.contextPath}/index.jsp';">
                    Inicio
                </button>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
