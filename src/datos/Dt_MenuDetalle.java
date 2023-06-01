/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.MenuDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elsner
 */
public class Dt_MenuDetalle {
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
            ps = con.prepareStatement("SELECT Menu_detalleID,MenuID,Menu_tipoID,Nombre,Descripcion,Precio FROM Menu_detalle", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<MenuDetalle> listarMenuDetalle(){
        ArrayList<MenuDetalle> listaMenuDetalle = new ArrayList<MenuDetalle>();
        try{
            this.cargarDatos();
            while(rs.next()){
                MenuDetalle MenDet = new MenuDetalle();
                MenDet.setMenu_detalleID(rs.getInt("Menu_detalleID"));
                MenDet.setMenuID(rs.getInt("MenuID"));
                MenDet.setMenu_tipoID(rs.getInt("Menu_tipoID"));
                MenDet.setNombre(rs.getString("Nombre"));
                MenDet.setDescripcion(rs.getString("Descripcion"));
                MenDet.setPrecio(rs.getFloat("Precio"));
                listaMenuDetalle.add(MenDet);
            }
        }catch(SQLException e){
            System.out.println("Error en listarMenuDetalle(): "+e.getMessage());
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
         return listaMenuDetalle;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public MenuDetalle getMenuDetalleByID(int Menu_detalleID){
        MenuDetalle menudetalle = new MenuDetalle();
        try{
            this.cargarDatos();
            while(rs.next()){
                if(Menu_detalleID==rs.getInt("location_id")){
                    menudetalle.setMenu_detalleID(rs.getInt("Menu_detalleID"));
                    menudetalle.setMenuID(rs.getInt("MenuID"));
                    menudetalle.setMenu_tipoID(rs.getInt("Menu_tipoID"));
                    menudetalle.setNombre(rs.getString("Nombre"));
                    menudetalle.setDescripcion(rs.getString("Descripcion"));
                    menudetalle.setPrecio(rs.getFloat("Precio"));
                    break;
                }
                
            }     
        }catch(SQLException e){
            System.out.println("El error en getMenuDetalleByID(): "+e.getMessage());
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
        
        
        return menudetalle;      
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean existeMenDet(MenuDetalle mendet){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre").equals(mendet.getNombre())){
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeMenuDetalle(): "+e.getMessage());
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
    public boolean guardarMenuDetalle (MenuDetalle mendet)
    {
        //declaramos una bandera en falso
	boolean guardado = false;
	try {
            this.cargarDatos();
            rs.moveToInsertRow();
            rs.updateInt("MenuID", mendet.getMenuID());
            rs.updateInt("Menu_tipoID", mendet.getMenu_tipoID());
            rs.updateString("Nombre", mendet.getNombre());
            rs.updateString("Descripcion", mendet.getDescripcion());
            rs.updateFloat("Precio", mendet.getPrecio());
           
            rs.insertRow();
            rs.moveToCurrentRow();
            //si el flujo llega hasta acá el registro se almacenó
            guardado = true; //hacemos verdadera la bandera
	}
	catch (SQLException e) {
            System.out.println("ERROR guardarMenuDetalle(): "+e.getMessage());
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
    public boolean editarMenuDetalle(MenuDetalle mendet)
    {
        //declaramos una bandera en falso
	boolean resp=false;
        try
        {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Menu_detalleID")==(mendet.getMenu_detalleID())){
                    rs.updateInt("MenuID", mendet.getMenuID());
                    rs.updateInt("Menu_tipoID", mendet.getMenu_tipoID());
                    rs.updateString("Nombre", mendet.getNombre());
                    rs.updateString("Descripcion", mendet.getDescripcion());
                    rs.updateFloat("Precio", mendet.getPrecio());
                    
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error en editarMenuDetalle(): "+e.getMessage());
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
    public boolean deleteMenuDetalle(MenuDetalle mendet){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Menu_detalleID")==mendet.getMenu_detalleID()){
                    rs.deleteRow();
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error deleteMenuDetalle(): "+e.getMessage());
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
