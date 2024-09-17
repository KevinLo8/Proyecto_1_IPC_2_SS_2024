/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.compra_anuncio;

import com.main.codigo_fuente.app.backend.database.ClaseDBPreciosAnuncios;
import com.main.codigo_fuente.app.backend.precios_anuncios.PreciosAnuncios;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorCompraAnuncio", urlPatterns = {"/compra_anuncio/Compra-Anuncio-servlet"})
public class ControladorCompraAnuncio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreciosAnuncios preciosAnuncios = new PreciosAnuncios();

        ClaseDBPreciosAnuncios db = new ClaseDBPreciosAnuncios();
        ResultSet resultSet = db.selectPrecios();

        preciosAnuncios.crearRes(resultSet);

        if (preciosAnuncios.sonInvalidos()) {
            resp.sendRedirect(req.getContextPath() + "/compra_anuncio/AnunciosSinPrecios.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/compra_anuncio/CompraAnuncio.jsp?precios=" + preciosAnuncios);
        }
    }
}
