/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.suscripcion_revista;

import com.main.codigo_fuente.app.backend.database.*;
import com.main.codigo_fuente.app.backend.revista.Revista;
import com.main.codigo_fuente.app.backend.suscripcion.Suscripcion;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorSuscripcionRevista", urlPatterns = {"/suscripcion-revista/suscripcion-revista-servlet"})
public class ControladorSuscripcionRevista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Revista revista = new Revista();
        ClaseDBRevista db = new ClaseDBRevista();
        ResultSet res = db.selectRevista(req.getParameter("nombreRevista"));

        try {
            res.next();
            revista.crearRes(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.cerrarDB();

        if (usuario.saldoSuficiente(revista.getPrecioRevista())) {
            Suscripcion suscripcion = new Suscripcion();
            suscripcion.crearReq(req);
            suscripcion.guardarSuscripcion();

            ClaseDBUsuario dbU = new ClaseDBUsuario();
            usuario.restarSaldo(revista.getPrecioRevista(), dbU);
            dbU.cerrarDB();

            resp.sendRedirect(req.getContextPath() + "/suscripcion-revista/suscripcion-revista-completa.jsp");
        } else {
            String error = "No se cuenta con suficiente credito para poder suscribirse.";
            req.setAttribute("revista", revista);
            req.setAttribute("error", error);
            req.getRequestDispatcher("/suscripcion-revista/suscripcion-revista.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        ResultSet res = db.selectRevista(req.getParameter("nombreRevista"));

        try {
            res.next();
            revista.crearRes(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        req.setAttribute("revista", revista);
        req.getRequestDispatcher("/suscripcion-revista/suscripcion-revista.jsp").forward(req, resp);
    }
}
