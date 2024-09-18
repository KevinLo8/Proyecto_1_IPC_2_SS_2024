<%-- 
    Document   : RegistroCompleto
    Created on : 12 sept 2024, 18:55:12
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicion completa</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Acreditacion de dinero completado.</h1>
                <p class="col-lg-6 mx-auto mb-4">
                    Se a acreditado con exito un catidad de ${param.cantidad} de dinero.
                </p>
                <p class="col-lg-6 mx-auto mb-4">
                    Su credito actual es de ${sessionScope.usuario.credito}.
                </p>
                <div class="btn-toolbar mt-2" role="toolbar">
                    <div class="col mt-2">
                        <a class="btn btn-primary" type="button"
                           href='${pageContext.servletContext.contextPath}/acreditar-dinero/acreditar-dinero.jsp';">
                            Regresar
                        </a>
                        <a class="btn btn-secondary ms-4" type="button"
                           href='${pageContext.servletContext.contextPath}/index.jsp';">
                            Inicio
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
