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
        <title>Suscripción completada</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Suscripción a revista completada</h1>
                <p class="col-lg-6 mx-auto mb-4">
                    Se a suscrito a la revista con exito.
                </p>

                <div class="container text-end mt-3">
                    <a href="${pageContext.servletContext.contextPath}/mostrador-revistas/mostrador-revistas-servlet" 
                       class="btn btn-primary px-5 mx-1" type="button">Revistas</a>
                    <a href="${pageContext.servletContext.contextPath}/index.jsp" class="btn btn-primary px-5 mx-1" type="button">Inicio</a>
                </div>

            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
</html>
