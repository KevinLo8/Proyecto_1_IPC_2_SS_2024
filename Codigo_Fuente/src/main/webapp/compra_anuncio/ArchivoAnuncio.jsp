<%-- 
    Document   : ArchivoAnuncio
    Created on : 15 sept 2024, 12:53:52
    Author     : kevin
--%>

<%@page import="com.main.codigo_fuente.app.backend.anuncio.Anuncio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Archivo de Anuncio</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container">
            <div class="offset-2 col-8">
                <h1 class="text-body-emphasis">Contenido del anuncio</h1>
                <form method="POST" action="${pageContext.servletContext.contextPath}/compra_anuncio/Guardar-Anuncio-servlet" enctype="multipart/form-data">
                    <%
                        Anuncio anuncio = (Anuncio) request.getAttribute("anuncio");
                        switch (anuncio.getTipoAnuncio()) {
                            case "TEXTO":
                    %>
                    <div class="mb-3">
                        <label for=" sampleInpuUserName" class="form-label">Escriba el texto para el anuncio</label>
                        <input type="text" class="form-control" name="texto" minlength="1" maxlength="100">
                    </div>
                    <%
                            break;
                        case "TEXTO E IMAGEN":
                    %>
                    <div class="mb-3">
                        <label for=" sampleInpuUserName" class="form-label">Escriba el texto para el anuncio</label>
                        <input type="text" class="form-control" name="texto" minlength="1" maxlength="100">
                    </div>

                    <div class="mb-3">
                        <label for=" sampleInpuUserName" class="form-label">Seleccione la imagen para el anuncio</label>
                        <input type="file" class="form-control" name="archivo">
                    </div>
                    <%
                            break;
                        case "VIDEO":
                    %>
                    <div class="mb-3">
                        <label for=" sampleInpuUserName" class="form-label">Seleccione el video para el anuncio</label>
                        <input type="file" class="form-control" name="archivo">
                    </div>
                    <%
                                break;
                        }
                    %>
                    <button method="POST" class="btn btn-primary">Crear Anuncio</button>

                    <div class="mb-3 mt-3">
                        <h1>${error}</h1>
                    </div>

                </form>        
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
