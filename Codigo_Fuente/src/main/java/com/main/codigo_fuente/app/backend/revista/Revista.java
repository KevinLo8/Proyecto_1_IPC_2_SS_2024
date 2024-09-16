/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.revista;

import com.main.codigo_fuente.app.backend.archivo.Archivo;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;

/**
 *
 * @author kevin
 */
public class Revista {

    private String nombreRevista;
    private String usuarioPublicador;
    private File archivoRevista;
    private int precioRevista;

    public String getNombreRevista() {
        return nombreRevista;
    }

    public String getUsuarioPublicador() {
        return usuarioPublicador;
    }

    public File getArchivoRevista() {
        return archivoRevista;
    }

    public int getPrecioRevista() {
        return precioRevista;
    }

    public void crearReq(HttpServletRequest req) throws DataErrorException, ServletException, IOException{
        nombreRevista = req.getParameter("nombre");
        
        Archivo archivo = new Archivo();
        InputStream inputStream = archivo.extraerInputStream(req, "revista");
        archivoRevista = archivo.inputStreamToFile(inputStream, nombreRevista, ".pdf");
        
        Usuario usuario = (Usuario)req.getSession().getAttribute("usuario");
        usuarioPublicador = usuario.getNombreUsuario();
        
        precioRevista = 0;
    }
    
    public void guardarRevista() {
        
    }

}
