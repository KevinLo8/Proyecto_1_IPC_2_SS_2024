/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.editar_precios_anuncios;

import com.main.codigo_fuente.app.backend.database.ClaseDBPreciosAnuncios;
import com.main.codigo_fuente.app.backend.exceptions.*;
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
@WebServlet(name = "ControladorCrearPreciosAnuncios", urlPatterns = {"/precios-anuncios/crear-edicion-precios-servlet"})
public class ControladorCrearPreciosAnuncios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreciosAnuncios preciosAnuncios = new PreciosAnuncios();

        ClaseDBPreciosAnuncios db = new ClaseDBPreciosAnuncios();
        ResultSet resultSet = db.selectPrecios();

        preciosAnuncios.crearRes(resultSet);

        db.cerrarDB();

        req.setAttribute("precios", preciosAnuncios);
        req.getRequestDispatcher("/precios-anuncios/editar-precios-anuncios.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreciosAnuncios preciosAnuncios = new PreciosAnuncios();

        try {
            preciosAnuncios.crearReq(req);
        } catch (DataErrorException ex) {
            lanzarError(req, resp, "Precios ingresados no son validos.");
        } catch (DataEmptyException ex) {
            lanzarError(req, resp, "falta llenar todos los espacios de precios.");
        }

        if (!preciosAnuncios.sonInvalidos()) {
            ClaseDBPreciosAnuncios db = new ClaseDBPreciosAnuncios();
            db.insertPrecios(preciosAnuncios);
            db.cerrarDB();
            req.getRequestDispatcher("/precios-anuncios/editar-precios-anuncios-completado.jsp").forward(req, resp);
        } else {
            lanzarError(req, resp, "Precios ingresados no son validos.");
        }
    }

    private void lanzarError(HttpServletRequest req, HttpServletResponse resp, String error) throws ServletException, IOException {
        req.setAttribute("error", error);
        req.getRequestDispatcher("/precios-anuncios/editar-precios-anuncios.jsp").forward(req, resp);
    }

}
