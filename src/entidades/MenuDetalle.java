/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class MenuDetalle {
    
    //Atributos
    private int Menu_detalleID;
    private int MenuID;
    private int Menu_tipoID;
    private String Nombre;
    private String Descripcion;
    private float Precio;
    
    //Constructor

    public MenuDetalle() {
    }
    
    public MenuDetalle(int Menu_detalleID, int MenuID, int Menu_tipoID, String Nombre, String Descripcion, float Precio) {
        this.Menu_detalleID = Menu_detalleID;
        this.MenuID = MenuID;
        this.Menu_tipoID = Menu_tipoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }

    //Metodos

    public int getMenu_detalleID() {
        return Menu_detalleID;
    }

    public void setMenu_detalleID(int Menu_detalleID) {
        this.Menu_detalleID = Menu_detalleID;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public int getMenu_tipoID() {
        return Menu_tipoID;
    }

    public void setMenu_tipoID(int Menu_tipoID) {
        this.Menu_tipoID = Menu_tipoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        //return "MenuDetalle{" + "Nombre=" + Nombre + '}';
        return this.getNombre();
    }
    
    
    
}
