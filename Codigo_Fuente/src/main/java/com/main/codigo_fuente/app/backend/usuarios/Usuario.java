package com.main.codigo_fuente.app.backend.usuarios;

import jakarta.servlet.http.HttpServletRequest;

public class Usuario {

    private String nombreUsuario;
    private TipoUsuarioEnum tipoUsuario;
    private String contraseñaUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }
    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public void crear(HttpServletRequest req) {
        setNombreUsuario(req.getParameter("usuario"));
        setTipoUsuario(TipoUsuarioEnum.valueOf(req.getParameter("tipo")));
        setContraseñaUsuario(req.getParameter("contraseña"));
    }
}
