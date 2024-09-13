<%-- 
    Document   : log_in
    Created on : 11 sept 2024, 17:13:37
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
        <div class="container">
            <div class="offset-2 col-8">
                <form method="POST" action="${pageContext.servletContext.contextPath}/inicio_sesion/inicio_sesion-servlet">
                    <div class="mb-3">
                        <label for=" sampleInpuUserName" class="form-label">Username</label>
                        <input type="text" class="form-control" name="usuario" value="${param.usuario}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="sampleInputPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" name="contraseña">
                    </div>
                    
                    <button method="POST" class="btn btn-primary">iniciar sesión</button>
                    
                    <div class="mb-3 mt-3">
                        <h1>${error}</h1>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="sampleInputPassword" class="form-label">No tienes una cuenta?</label>
                        <a class="link" href="sign-up.jsp">Registrarse</a>
                    </div>
                </form>        
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
