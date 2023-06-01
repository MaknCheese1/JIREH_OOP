/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Usuario {
    
    //Atributos
    
    private int UsuarioID;
    private int RolID;
    private String Nombre_usuario;
    private String Clave;
    private int Estado;
    
    //Constructor

    public Usuario() {
    }
    
    public Usuario(int UsuarioID, int RolID, String Nombre_usuario, String Clave, int Estado) {
        this.UsuarioID = UsuarioID;
        this.RolID = RolID;
        this.Nombre_usuario = Nombre_usuario;
        this.Clave = Clave;
        this.Estado = Estado;
    }
    
    
    //Metodos

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String Nombre_usuario) {
        this.Nombre_usuario = Nombre_usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    
}
