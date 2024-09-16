<%-- 
    Document   : agregar-tag-nuevo
    Created on : 15 sept 2024, 20:49:27
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Categoria</title>
        <jsp:include page="../includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container my-5">
            <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
                <h1 class="text-body-emphasis">Agregar un Nueva Categoria</h1>
                <form method="POST" action="${pageContext.servletContext.contextPath}/agregar-categoria/agregar-categoria-servlet">

                    <div class="mb-3">
                        <%
                            String[] categorias = (String[]) request.getAttribute("categorias");
                        %>

                        <label class="form-label">Categorias Existentes</label>
                        <ul class="list-group">
                            <%
                                for (int i = 0; i < categorias.length; i++) {
                                    request.setAttribute("categoria", categorias[i]);
                            %>
                            <li class="list-group-item">${categoria}</li>
                                <%
                                    }
                                %>
                        </ul>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Escriba la categoria que quiere agregar</label>
                        <input type="text" class="form-control" name="texto" minlength="1" maxlength="50">
                    </div>

                    <button method="POST" class="btn btn-primary">Agregar Categoria</button>

                    <div class="mb-3 mt-3">
                        <h1>${error}</h1>
                    </div>

                </form>        
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
