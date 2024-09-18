/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.compra_anuncio;

import com.main.codigo_fuente.app.backend.anuncio.Anuncio;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ContraladorGenerarCompra", urlPatterns = {"/compra_anuncio/Generar-Compra-servlet"})
public class ContraladorGenerarCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        if (req.getAttribute("tipo") == null || req.getAttribute("duración") == null) {
                        String error = "No se a seleccionado un tipo o una duracion de anuncio,.";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/compra_anuncio/CompraAnuncio.jsp").forward(req, resp);
        } else if (usuario.saldoSuficiente(Double.valueOf(req.getParameter("costo")))) {
            Anuncio anuncio = new Anuncio();
            anuncio.crearReq(req, usuario.getNombreUsuario());
            resp.sendRedirect(req.getContextPath() + "/compra_anuncio/ArchivoAnuncio.jsp?anuncio=" + anuncio);
        } else {
            String error = "Saldo insuficienta para poder comprar el anuncio.";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/compra_anuncio/CompraAnuncio.jsp").forward(req, resp);

        }
    }
}
