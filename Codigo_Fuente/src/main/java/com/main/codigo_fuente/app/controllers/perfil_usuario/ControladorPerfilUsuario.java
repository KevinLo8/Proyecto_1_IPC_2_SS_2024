/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.perfil_usuario;

import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorPerfilUsuario", urlPatterns = {"/perfil-usuario/perfil-usuario-servlet"})
public class ControladorPerfilUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        usuario.copiarInfo(req);
        usuario.guardarInfo();

        String completo = "Se a guardado la información con exito.";
        req.setAttribute("completo", completo);
        req.getRequestDispatcher("/perfil-usuario/perfil-usuario.jsp").forward(req, resp);

    }

}
