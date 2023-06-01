/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dennis Caldera
 */
public class Menu {
    
    //Atributos
    private int MenuID;
    private int RestauranteID;
    private String Nombre_menu;
    private String Descripcion;
    
    //Constructor

    public Menu() {
    }
    
    public Menu(int MenuID, int RestauranteID, String Nombre_menu, String Descripcion) {
        this.MenuID = MenuID;
        this.RestauranteID = RestauranteID;
        this.Nombre_menu = Nombre_menu;
        this.Descripcion = Descripcion;
    }

    //Metodos

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public int getRestauranteID() {
        return RestauranteID;
    }

    public void setRestauranteID(int RestauranteID) {
        this.RestauranteID = RestauranteID;
    }

    public String getNombre_menu() {
        return Nombre_menu;
    }

    public void setNombre_menu(String Nombre_menu) {
        this.Nombre_menu = Nombre_menu;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        //return "Menu{" + "Nombre_menu=" + Nombre_menu + '}';
        return this.getNombre_menu();
    }
    
    
}
