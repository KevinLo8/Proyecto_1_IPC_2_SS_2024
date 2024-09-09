package com.main.codigo_fuente.app.backend.usuarios;

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
}
