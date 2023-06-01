/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Cliente {
    
    //Atributos
    private int ClienteID;
    private int RestauranteID;
    private String Nombre_cliente;
    private String Telefono_cliente;
    private String Direccion;
    private String Tipo_cliente;
    private int Estado;
    
    //Constructor

     public Cliente() {
    }
    
    public Cliente(int ClienteID, int RestauranteID, String Nombre_cliente, String Telefono_cliente, String Direccion, String Tipo_cliente, int Estado) {
        this.ClienteID = ClienteID;
        this.RestauranteID = RestauranteID;
        this.Nombre_cliente = Nombre_cliente;
        this.Telefono_cliente = Telefono_cliente;
        this.Direccion = Direccion;
        this.Tipo_cliente = Tipo_cliente;
        this.Estado = Estado;
    }

    //Metodos

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public int getRestauranteID() {
        return RestauranteID;
    }

    public void setRestauranteID(int RestauranteID) {
        this.RestauranteID = RestauranteID;
    }

    public String getNombre_cliente() {
        return Nombre_cliente;
    }

    public void setNombre_cliente(String Nombre_cliente) {
        this.Nombre_cliente = Nombre_cliente;
    }

    public String getTelefono_cliente() {
        return Telefono_cliente;
    }

    public void setTelefono_cliente(String Telefono_cliente) {
        this.Telefono_cliente = Telefono_cliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTipo_cliente() {
        return Tipo_cliente;
    }

    public void setTipo_cliente(String Tipo_cliente) {
        this.Tipo_cliente = Tipo_cliente;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
   
    
}
