<%-- 
    Document   : header
    Created on : 10 sept 2024, 20:21:49
    Author     : kevin
--%>

<%@page import="com.main.codigo_fuente.app.backend.usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
    <div class="container" style="background-color: darkblue">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <img src="${pageContext.servletContext.contextPath}/pngs/header_image.png" alt="imagen" height="50" width="250"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp" class="nav-link px-2 text-secondary">Inicio</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
            </form>

            <%
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                if (usuario == null) {
            %>
            <div class="text-end">
                <button type="button" class="btn btn-outline-light me-2" 
                        onclick="javascript:window.location = '${pageContext.servletContext.contextPath}/login/login.jsp';">Iniciar sesión</button>
                <button type="button" class="btn btn-warning"
                        onclick="javascript:window.location = '${pageContext.servletContext.contextPath}/login/sign-up.jsp';">registrarse</button>
            </div>
            <%
            } else {
            %>
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    ${nombreUsuario}
                </a>
                <ul class="dropdown-menu" style="">
                    <li><a class="dropdown-item" href="#">Ver Perfil</a></li>
                        <%
                            switch (usuario.getTipoUsuario().toString()) {
                                case "ADMINISTRADOR":
                        %>
                    <li><a class="dropdown-item" href="#">Editar Precios de Anuncios</a></li>
                    <li><a class="dropdown-item" href="#">Revisar Revistas</a></li>
                    <li><a class="dropdown-item" href="#">Editar Precios de Revistas</a></li>
                    <li><a class="dropdown-item" href="#">Ver Reportes</a></li>
                        <%
                                break;
                            case "COMPRADOR":
                        %>
                    <li><a class="dropdown-item" href="#">Comprar Anuncio</a></li>
                    <li><a class="dropdown-item" href="#">Ver Anuncios Comprados</a></li>
                    <li><a class="dropdown-item" href="#">Acrerditar Dinero</a></li>
                        <%
                                break;
                            case "EDITOR":
                        %>
                    <li><a class="dropdown-item" href="#">Publicar Revista</a></li>
                    <li><a class="dropdown-item" href="#">Editar Revistas</a></li>
                    <li><a class="dropdown-item" href="#">Ver Reportes</a></li>
                        <%
                                break;
                            case "SUSCRIPTOR":
                        %>
                    <li><a class="dropdown-item" href="#">Buscardor de Revistas</a></li>
                    <li><a class="dropdown-item" href="#">Acrerditar Dinero</a></li>
                        <%
                                    break;
                            }
                        %>
                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/login/CerrarSesionCompleto.jsp">Cerrar Sesión</a></li>
                </ul>
            </div>
            <%
                }
            %>


        </header>
    </div>
</main>