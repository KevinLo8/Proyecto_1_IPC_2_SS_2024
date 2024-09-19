/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.revistas_suscritas;

import com.main.codigo_fuente.app.backend.database.ClaseDBSuscripcion;
import com.main.codigo_fuente.app.backend.suscripcion.*;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorRevistasSuscritas", urlPatterns = {"/revistas-suscritas/revistas-suscritas-servlet"})
public class ControladorRevistasSuscritas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario)req.getSession().getAttribute("usuario");
        ClaseDBSuscripcion db = new ClaseDBSuscripcion();
        ResultSet res = db.selectSuscripcionRevistas(usuario.getNombreUsuario());
        Suscripciones sus = new Suscripciones();
        
        Suscripcion[] suscripciones = sus.pedirSuscripciones(res);
        
        req.setAttribute("suscripciones", suscripciones);
        req.getRequestDispatcher("/revistas-suscritas/revistas-suscritas.jsp").forward(req, resp);

    }
    
}
