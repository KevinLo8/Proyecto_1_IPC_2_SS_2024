<%-- 
    Document   : header
    Created on : 10 sept 2024, 20:21:49
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.main.codigo_fuente.app.backend.usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
    <div class="container" style="background-color: black">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a class="d-flex align-items-center mb-3 mb-md-0 me-md-0 link-body-emphasis text-decoration-none">
                <img src="${pageContext.servletContext.contextPath}/pngs/header_image.png" alt="imagen" height="50" width="250"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp" class="nav-link px-2 text-info">Inicio</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/mostrador-revistas/mostrador-revistas-servlet" class="nav-link px-2 text-info">Revistas</a></li>
            </ul>

            <c:choose>
                <c:when test="${usuario == null}">
                    <div class="text-end">
                        <a type="button" class="btn btn-outline-light me-2" href="${pageContext.servletContext.contextPath}/login/login.jsp">Iniciar sesión</a>
                        <a type="button" class="btn btn-warning" href="${pageContext.servletContext.contextPath}/login/sign-up.jsp">registrarse</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="dropdown">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${nombreUsuario}
                        </a>
                        <ul class="dropdown-menu" style="">
                            <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/perfil-usuario/perfil-usuario.jsp">Ver Perfil</a></li>
                                <c:choose>
                                    <c:when test="${sessionScope.usuario.tipoUsuario == 'ADMINISTRADOR'}">
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/precios-anuncios/crear-edicion-precios-servlet">Editar Precios de Anuncios</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/precios-revistas/crear-edicion-revista-servlet">Editar Precios de Revistas</a></li>
                                    <li><a class="dropdown-item" href="#">Ver Reportes</a></li>
                                    </c:when>
                                    <c:when test="${sessionScope.usuario.tipoUsuario == 'COMPRADOR'}">
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/compra_anuncio/Compra-Anuncio-servlet">Comprar Anuncio</a></li>
                                    <li><a class="dropdown-item" href="#">Ver Anuncios Comprados</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/acreditar-dinero/acreditar-dinero.jsp">Acrerditar Dinero</a></li>
                                    </c:when>
                                    <c:when test="${sessionScope.usuario.tipoUsuario == 'EDITOR'}">
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/publicar-revista/generar-publicacion-servlet">Publicar Revista</a></li>
                                    <li><a class="dropdown-item" href="#">Editar Revistas</a></li>
                                    <li><a class="dropdown-item" href="#">Ver Reportes</a></li>
                                    </c:when>
                                    <c:when test="${sessionScope.usuario.tipoUsuario == 'SUSCRIPTOR'}">
                                    <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/acreditar-dinero/acreditar-dinero.jsp">Acrerditar Dinero</a></li>
                                    </c:when>
                                </c:choose>
                            <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/inicio_sesion/cerrar_sesion-servlet">Cerrar Sesión</a></li>
                        </ul>
                    </div>
                </c:otherwise>
            </c:choose>
        </header>
    </div>
</main>
