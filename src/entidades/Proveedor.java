/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Proveedor {
    
    //Atributos
    private int ProveedorID;
    private int RestauranteID;
    private String Nombre_proveedor;
    private String Telefono_proveedor;
    private String Correo_proveedor;
    private String Descripcion;
    private String Pagina_web;
    //Constructor
    public Proveedor() {
    }
    
    public Proveedor(int ProveedorID, int RestauranteID, String Nombre_proveedor, String Telefono_proveedor, String Correo_proveedor, String Descripcion, String Pagina_web) {
        this.ProveedorID = ProveedorID;
        this.RestauranteID = RestauranteID;
        this.Nombre_proveedor = Nombre_proveedor;
        this.Telefono_proveedor = Telefono_proveedor;
        this.Correo_proveedor = Correo_proveedor;
        this.Descripcion = Descripcion;
        this.Pagina_web = Pagina_web;
    }
    
    
    //Metodos

    public int getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(int ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public int getRestauranteID() {
        return RestauranteID;
    }

    public void setRestauranteID(int RestauranteID) {
        this.RestauranteID = RestauranteID;
    }

    public String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = Nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return Telefono_proveedor;
    }

    public void setTelefono_proveedor(String Telefono_proveedor) {
        this.Telefono_proveedor = Telefono_proveedor;
    }

    public String getCorreo_proveedor() {
        return Correo_proveedor;
    }

    public void setCorreo_proveedor(String Correo_proveedor) {
        this.Correo_proveedor = Correo_proveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPagina_web() {
        return Pagina_web;
    }

    public void setPagina_web(String Pagina_web) {
        this.Pagina_web = Pagina_web;
    }

   
    
}
