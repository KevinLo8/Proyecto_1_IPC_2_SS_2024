package com.main.codigo_fuente.app.controllers.inicio_sesion;

import com.main.codigo_fuente.app.backend.LogIn.ChequeadorLogIn;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ControladorInicioSesion", urlPatterns = {"/inicio_sesion/inicio_sesion-servlet"})
public class ControladorInicioSesion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChequeadorLogIn chequeadorLogIn = new ChequeadorLogIn();
        try {
            chequeadorLogIn.ChequearUsuario(req);
        } catch (DataErrorException ex) {
            String error = "Nombre de usuario o contraseña incorrecto.";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
        }
        req.getSession().setAttribute("nombre-usuario", req.getAttribute("usuario"));
        req.getRequestDispatcher("/login/InicioSesionCompleto.jsp").forward(req, resp);
    }

}
