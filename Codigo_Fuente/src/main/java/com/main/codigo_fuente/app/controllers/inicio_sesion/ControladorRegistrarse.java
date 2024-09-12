package com.main.codigo_fuente.app.controllers.inicio_sesion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ControladorInicioSesion", urlPatterns = {"/Registarse/Registarse-servlet"})
public class ControladorRegistrarse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
