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
                    <h4 class="mb-3">Billing address</h4>
                    <form class="needs-validation" novalidate="">
                        
                        <div class="row g-3 mb-4">
                            
                            <div class="col-12">
                                <label for="username" class="form-label">Nombre de usuario</label>
                                <div class="input-group has-validation">
                                    <input type="text" class="form-control" id="username" placeholder="Nombre de usuario" required="">
                                    <div class="invalid-feedback">
                                        se requiere un nombre de usuario.
                                    </div>
                                </div>
                            </div>

                            <div class="col-12">
                                <label>Seleccione el tipo de cuenta que quiere crear</label>
                                
                                <select class="form-select">
                                    <option selected>----Seleccione tipo----</option>
                                    <option value="Administrador">Administrador</option>
                                    <option value="Comprador">Comprador</option>
                                    <option value="Editor">Editor</option>
                                    <option value="Suscriptor">Suscriptor</option>
                                </select>
                                
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="password" placeholder="Contraseña" required="">
                                <div class="invalid-feedback">
                                    se requiere una contraseña.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="address" class="form-label">Confirmar contraseña</label>
                                <input type="password" class="form-control" id="password_confir" placeholder="Confirmar contraseña" required="">
                                <div class="invalid-feedback">
                                    se requiere una contraseña.
                                </div>
                            </div>
                            
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" type="submit" id="btn1">Registrarse</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
                
    </body>
</html>
