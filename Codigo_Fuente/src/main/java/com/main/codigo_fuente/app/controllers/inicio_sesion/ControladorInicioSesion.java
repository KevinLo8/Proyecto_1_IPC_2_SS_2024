package com.main.codigo_fuente.app.controllers.inicio_sesion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ControladorInicioSesion", urlPatterns = {"/inicio_sesion/inicio_sesion-servlet"})
public class ControladorInicioSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
