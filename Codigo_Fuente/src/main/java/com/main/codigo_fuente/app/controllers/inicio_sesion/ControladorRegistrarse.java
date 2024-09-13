package com.main.codigo_fuente.app.controllers.inicio_sesion;

import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;
import com.main.codigo_fuente.app.backend.usuarios.CreadorUsuario;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ControladorRegistrarse", urlPatterns = {"/Registarse/Registarse-servlet"})
public class ControladorRegistrarse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreadorUsuario creadorUsuario = new CreadorUsuario();
        try {
            creadorUsuario.crearUsuario(req);
        } catch (UserNameExistsException ex) {
        }
        req.getRequestDispatcher("/login/registroCompleto.jsp").forward(req, resp);
    }

}
