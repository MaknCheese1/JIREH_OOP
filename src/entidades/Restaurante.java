/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Restaurante {
    
    //Atributos
    
    private int RestauranteID;
    private String Nombre_restaurante;
    private String Telefono_restaurante;
    private String Correo_restaurante;
    private String Direccion;
    private String Numero_ruc;
    private String Pagina_web;
    
    //Constructor
     public Restaurante() {
    }
    
     public Restaurante(int RestauranteID, String Nombre_restaurante, String Telefono_restaurante, String Correo_restaurante, String Direccion, String Numero_ruc, String Pagina_web) {
        this.RestauranteID = RestauranteID;
        this.Nombre_restaurante = Nombre_restaurante;
        this.Telefono_restaurante = Telefono_restaurante;
        this.Correo_restaurante = Correo_restaurante;
        this.Direccion = Direccion;
        this.Numero_ruc = Numero_ruc;
        this.Pagina_web = Pagina_web;
    }
     
    //Metodos

    public int getRestauranteID() {
        return RestauranteID;
    }

    public void setRestauranteID(int RestauranteID) {
        this.RestauranteID = RestauranteID;
    }

    public String getNombre_restaurante() {
        return Nombre_restaurante;
    }

    public void setNombre_restaurante(String Nombre_restaurante) {
        this.Nombre_restaurante = Nombre_restaurante;
    }

    public String getTelefono_restaurante() {
        return Telefono_restaurante;
    }

    public void setTelefono_restaurante(String Telefono_restaurante) {
        this.Telefono_restaurante = Telefono_restaurante;
    }

    public String getCorreo_restaurante() {
        return Correo_restaurante;
    }

    public void setCorreo_restaurante(String Correo_restaurante) {
        this.Correo_restaurante = Correo_restaurante;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNumero_ruc() {
        return Numero_ruc;
    }

    public void setNumero_ruc(String Numero_ruc) {
        this.Numero_ruc = Numero_ruc;
    }

    public String getPagina_web() {
        return Pagina_web;
    }

    public void setPagina_web(String Pagina_web) {
        this.Pagina_web = Pagina_web;
    }

    @Override
    public String toString() {
       /* return "Restaurante{" + "Nombre_restaurante=" + Nombre_restaurante + '}'*/
       return this.getNombre_restaurante();
    }

    

   
    
}
