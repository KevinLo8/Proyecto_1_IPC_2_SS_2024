<%-- 
    Document   : publicar_revista
    Created on : 15 sept 2024, 18:12:15
    Author     : kevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Publicación de Nueva Revista</h1>
                <form method="POST" action="${pageContext.servletContext.contextPath}/publicar-revista/publicar-revista-servlet" enctype="multipart/form-data">

                    <div class="mb-3">
                        <label class="form-label">Escriba el nombre para la revista</label>
                        <input type="text" class="form-control" name="nombre" min="1" max="50" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Seleccione el archivo de la revista que quiere publicar</label>
                        <input type="file" class="form-control" name="revista" required>
                    </div>

                    <div class="mb-3">
                        <c:choose>
                            <c:when test="${fn:length(tags) == 0}">
                                <label class="form-label">No hay ningun tag disponible, por favor agregar alguno con el boton de abajo.</label>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${tags}" var="tag">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="${tag}" name="tagsSelect" id="flexCheckChecked">
                                        <label class="form-check-label">${tag}</label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>   
                    </div>

                    <div class="mb-3">
                        <a href="${pageContext.servletContext.contextPath}/agregar-tag/agregar-nuevo-tag-servlet" class="btn btn-secondary" role="button">Agregar Nuevo Tag</a>
                    </div>      

                    <div class="mb-3">
                        <c:choose>
                            <c:when test="${fn:length(categorias) == 0}">
                                <label class="form-label">No hay ninguna categoria disponible, por favor agregar alguna con el boton de abajo.</label>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${categorias}" var="categoria">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" value="${categoria}" name="categoriaSelect">
                                        <label class="form-check-label">${categoria}</label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>   
                    </div>

                    <div class="mb-3">
                        <a href="${pageContext.servletContext.contextPath}/agregar-categoria/agregar-nuevo-categoria-servlet" class="btn btn-secondary" role="button">Agregar Nueva Categoria</a>
                    </div>      

                    <button method="POST" class="btn btn-primary">Publicar Revista</button>

                    <p class="text-center fs-2 text-danger mb-5 mt-5">${error}</p>

                </form>        
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
