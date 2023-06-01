/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class MenuTipo {
    //Atributos
    private int Menu_tipoID;
    private String Nombre;
    private String Descripcion;
    private int Estado;
    
    //Constructor
    public MenuTipo() {
    }
    
    
    public MenuTipo(int Menu_tipoID, String Nombre, String Descripcion, int Estado) {
        this.Menu_tipoID = Menu_tipoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    //Metodo

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

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
       // return "MenuTipo{" + "Nombre=" + Nombre + '}';
       return this.getNombre();
    }
   
    
}
