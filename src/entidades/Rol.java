/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Rol {
    
    //Atributos
    private int RolID;
    private String Rol_nombre;
    private int Estado;
    
    //Constructor
    public Rol() {
    }
    
      public Rol(int RolID, String Rol_nombre, int Estado) {
        this.RolID = RolID;
        this.Rol_nombre = Rol_nombre;
        this.Estado = Estado;
    }
      
    //Metodos

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
    }

    public String getRol_nombre() {
        return Rol_nombre;
    }

    public void setRol_nombre(String Rol_nombre) {
        this.Rol_nombre = Rol_nombre;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        //return "Rol{" + "Rol_nombre=" + Rol_nombre + '}';
        return this.getRol_nombre();
    }

  

    
    
}
