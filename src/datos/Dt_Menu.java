/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elsner
 */
public class Dt_Menu {
    //atributos
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //metodos
     @SuppressWarnings("CallToPrintStackTrace")
    public void cargarDatos()
    {
        try{
            con = Conexion.getConnection(); //obtenemos la conexion a la base de datos
            ps = con.prepareStatement("SELECT MenuID,RestauranteID,Nombre_menu,Descripcion FROM Menu", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Menu> listarMenu(){
        ArrayList<Menu> listaMenu = new ArrayList<Menu>();
        try{
            this.cargarDatos();
            while(rs.next()){
                Menu men = new Menu();
                men.setMenuID(rs.getInt("MenuID"));
                men.setRestauranteID(rs.getInt("RestauranteID"));
                men.setNombre_menu(rs.getString("Nombre_menu"));
                men.setDescripcion(rs.getString("Descripcion"));
                listaMenu.add(men);
            }
        }catch(SQLException e){
            System.out.println("Error en listarMenu(): "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    Conexion.closeConexion(con);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
         return listaMenu;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public Menu getMenuByID(int MenuID){
        Menu menu = new Menu();
        try{
            this.cargarDatos();
            while(rs.next()){
                if(MenuID==rs.getInt("location_id")){
                    menu.setMenuID(rs.getInt("MenuID"));
                    menu.setRestauranteID(rs.getInt("RestauranteID"));
                    menu.setNombre_menu(rs.getString("Nombre_menu"));
                    menu.setDescripcion(rs.getString("Descripcion"));
                    
                    break;
                }
                
            }     
        }catch(SQLException e){
            System.out.println("El error en getLocationByID(): "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    Conexion.closeConexion(con);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }  
        }
        
        
        return menu;      
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean guardarMenu (Menu Men)
    {
        //declaramos una bandera en falso
	boolean guardado = false;
	try {
            this.cargarDatos();
            rs.moveToInsertRow();
            
            rs.updateInt("RestauranteID", Men.getRestauranteID());
            rs.updateString("Nombre_menu", Men.getNombre_menu());
            rs.updateString("Descripcion", Men.getDescripcion());

            rs.insertRow();
            rs.moveToCurrentRow();
            //si el flujo llega hasta acá el registro se almacenó
            guardado = true; //hacemos verdadera la bandera
	}
	catch (SQLException e) {
            System.out.println("ERROR guardarMenu(): "+e.getMessage());
            e.printStackTrace();
	}
	finally
	{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    Conexion.closeConexion(con);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
	}
                //returnamos el valor de la bandera
	return guardado;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean editarMen(Menu Men)
    {
        //declaramos una bandera en falso
	boolean resp=false;
        try
        {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("MenuID")==(Men.getMenuID())){
                   rs.updateInt("RestauranteID", Men.getRestauranteID());
                   rs.updateString("Nombre_menu", Men.getNombre_menu());
                   rs.updateString("Descripcion", Men.getDescripcion());
                   rs.updateRow();
                    resp = true;
                    break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error en editarMenu(): "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try {
                    if(rs!=null){
                    rs.close();
                    }
                    if(ps!=null){
                        ps.close();
                    }
                    if(con!=null){
                        Conexion.closeConexion(con);
                    }
            }catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
        return resp;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean deleteMen(Menu Men){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("MenuID")==Men.getMenuID()){
                    rs.deleteRow();
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error deleteMenu(): "+e.getMessage());
            e.printStackTrace();
	}
        finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    Conexion.closeConexion(con);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
		
        return resp;
    }
    
     @SuppressWarnings("CallToPrintStackTrace")
    public boolean existeMenu(Menu Men){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre_menu").equals(Men.getNombre_menu())){
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeMenu(): "+e.getMessage());
            e.printStackTrace();
	}
        finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    Conexion.closeConexion(con);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
		
        return resp;
    }
    }


