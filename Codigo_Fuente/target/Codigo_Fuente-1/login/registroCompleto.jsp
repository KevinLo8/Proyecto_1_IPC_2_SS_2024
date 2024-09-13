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
        <title>Registro correcto</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Registro completo</h1>
                <p class="col-lg-6 mx-auto mb-4">
                    El usuario a sido registrado con exito.
                </p>
                <button class="btn btn-primary px-5 mb-5" type="button"
                        onclick="javascript:window.location = '${pageContext.servletContext.contextPath}/login/login.jsp';">
                    Iniciar Sesión
                </button>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
