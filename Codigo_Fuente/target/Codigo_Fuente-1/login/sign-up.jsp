<%-- 
    Document   : sing_up
    Created on : 11 sept 2024, 17:13:51
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
            <div class="py-5 text-center">
                <h2>Registrar nuevo usuario</h2>
                <p class="lead">Llenar los datos que se puden abajo para poder registrar un nuevo usuario.</p>
            </div>

            <div class="offset-2 col-8">
                <div class="col-lg-12">
                    <h4 class="mb-3">Datos para registrase</h4>
                    <form class="needs-validation" method="POST" action="${pageContext.servletContext.contextPath}/Registarse/Registarse-servlet">

                        <div class="row g-3 mb-4">

                            <div class="col-12">
                                <label for="username" class="form-label">Nombre de usuario</label>
                                <div class="input-group has-validation">
                                    <input type="text" class="form-control" value="${param.usuario}" placeholder="Nombre de usuario" name="usuario" minlength="1" maxlength="100" required>
                                    <div class="invalid-feedback">
                                        se requiere un nombre de usuario.
                                    </div>
                                </div>
                            </div>

                            <div class="col-12">
                                <label>Seleccione el tipo de cuenta que quiere crear</label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="tipo" value="ADMINISTRADOR" id="CheckRadio">
                                    <label class="form-check-label" for="CheckRadio">
                                        Administrador
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="tipo" value="COMPRADOR" id="CheckRadio">
                                    <label class="form-check-label" for="CheckRadio">
                                        Comprador
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="tipo" value="EDITOR" id="CheckRadio">
                                    <label class="form-check-label" for="CheckRadio">
                                        Editor
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="tipo" value="SUSCRIPTOR" id="CheckRadio">
                                    <label class="form-check-label" for="CheckRadio">
                                        Suscriptor
                                    </label>
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" placeholder="Contraseña" name="contraseña" minlength="1" maxlength="100" required>
                                <div class="invalid-feedback">
                                    se requiere una contraseña.
                                </div>
                            </div>

                        </div>

                        <div class="mb-3 mt-3">
                            <h1>${error}</h1>
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" method="POST">Registrarse</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>      
    </body>
</html>
