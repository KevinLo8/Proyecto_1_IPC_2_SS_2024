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
        if (req.getAttribute("tipo") == null) {
            String error = "Tipo de usuario no seleccionado.";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/login/sign-up.jsp").forward(req, resp);
        } else {
            CreadorUsuario creadorUsuario = new CreadorUsuario();
            try {
                creadorUsuario.crearUsuario(req);
            } catch (UserNameExistsException ex) {
                String error = "Nombre de usuario ya existente.";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/login/sign-up.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/login/registroCompletado.jsp").forward(req, resp);
        }
    }

}
