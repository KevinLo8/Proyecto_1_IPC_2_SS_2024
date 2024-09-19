/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.mostrador_revistas;

import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.revista.*;
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
@WebServlet(name = "ControladorMostrardorRevistas", urlPatterns = {"/mostrador-revistas/mostrador-revistas-servlet"})
public class ControladorMostrardorRevistas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        ClaseDBRevista db = new ClaseDBRevista();
        ResultSet resultSet = db.selectRevistas();

        Revista[] revistas = Revistas.separarRevistas(resultSet);
        db.cerrarDB();

        for (Revista revista : revistas) {
            revista.guardarInfo();
            if (usuario == null) {
                revista.setSuscrito(false);
            } else {
                revista.revisarSuscripcion(usuario.getNombreUsuario());
            }
        }

        req.setAttribute("revistas", revistas);
        req.getRequestDispatcher("/mostrador-revistas/mostrador-revistas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        try {
            ResultSet resultSet = db.selectRevista(req.getParameter("nombreRevista"));
            resultSet.next();
            revista.crearRes(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.cerrarDB();

        req.setAttribute("revista", revista);
        req.getRequestDispatcher("/mostrador-revistas/mostrar-revista.jsp").forward(req, resp);

    }

}
