<%-- 
    Document   : CompraAnuncio
    Created on : 14 sept 2024, 18:44:42
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
                <img class="d-block mx-auto mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
                <h2>Compra de Anuncio</h2>
                <p class="lead">Seleccione el tipo del anuncio y la duración que va a tener el anuncio.</p>
            </div>

            <div class="row g-5">
                <div class="col-md-5 col-lg-4 order-md-last">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">Costos de la Compra</span>
                        <span class="badge bg-primary rounded-pill">3</span>
                    </h4>
                    <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Saldo Disponible</h6>
                                <small class="text-body-secondary">Brief description</small>
                            </div>
                            <span class="text-body-secondary">$12</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Tipo de Anuncio</h6>
                                <small class="text-body-secondary">Brief description</small>
                            </div>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Tiempo de Duración</h6>
                                <small class="text-body-secondary">Brief description</small>
                            </div>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Costo de Anuncio</h6>
                                <small>EXAMPLECODE</small>
                            </div>
                            <span class="text-body-secondary">$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (USD)</span>
                            <strong>$20</strong>
                        </li>
                    </ul>

                    <form class="card p-2">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Promo code">
                            <button type="submit" class="btn btn-secondary">Redeem</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-7 col-lg-8">
                    <h4 class="mb-3">Informacion de Compra</h4>
                    <form method="POST" action="${pageContext.servletContext.contextPath}/compra_anuncio/Generar-Compra-servlet">

                        <div class="col-12">
                            <label>Seleccione el tipo de anuncio que quiere comprar</label>
                            <select class="form-select" name="tipo">
                                <option selected>----Seleccione el tipo----</option>
                                <option value="TEXTO">Anuncio de Texto</option>
                                <option value="TEXTO E IMAGEN">Anuncio de Texto e Imagen</option>
                                <option value="VIDEO">Anuncio de Video</option>
                            </select>
                        </div>

                        <div class="col-12">
                            <label>Seleccione la duración de vigencia que quiere que tenga el anuncio</label>
                            <select class="form-select" name="duración">
                                <option selected>----Seleccione la duracion----</option>
                                <option value="1 DIA">Vigencia de 1 Dia</option>
                                <option value="3 DIAS">Vigencia de 3 Dias</option>
                                <option value="1 SEMANA">Vigencia de 1 Semana</option>
                                <option value="2 SEMANAS">Vigencia de 2 Semanas</option>
                            </select>
                        </div>

                        <div class="mb-3 mt-3">
                            <h1>${error}</h1>
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
