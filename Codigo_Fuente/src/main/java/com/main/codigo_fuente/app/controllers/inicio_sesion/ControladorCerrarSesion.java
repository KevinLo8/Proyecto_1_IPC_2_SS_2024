package com.main.codigo_fuente.app.controllers.inicio_sesion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ControladorCerrarSesion", urlPatterns = {"/inicio_sesion/cerrar_sesion-servlet"})
public class ControladorCerrarSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("usuario");
        req.getSession().removeAttribute("nombreUsuario");
        req.getRequestDispatcher("/login/CerrarSesionCompletado.jsp").forward(req, resp);
    }

}
