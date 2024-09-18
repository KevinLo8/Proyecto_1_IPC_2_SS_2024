/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.acreditar_dinero;

import com.main.codigo_fuente.app.backend.database.ClaseDBUsuario;
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
@WebServlet(name = "ControladorAcreditarDinero", urlPatterns = {"/acreditar-dinero/acreditar-dinero-servlet"})
public class ControladorAcreditarDinero extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBUsuario db = new ClaseDBUsuario();
        Usuario usuario = new Usuario();
        ResultSet res = db.selectUser(req.getParameter("nombreUsuario"));

        try {
            res.next();
            usuario.crearRes(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        usuario.acreditarSaldo(Double.valueOf(req.getParameter("cantidad")), db);
        db.cerrarDB();

        req.getSession().setAttribute("usuario", usuario);
        req.getRequestDispatcher("/acreditar-dinero/acreditar-dinero-completado.jsp").forward(req, resp);
    }

}
