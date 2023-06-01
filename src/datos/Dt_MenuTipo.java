/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.MenuTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elsner
 */
public class Dt_MenuTipo {
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
            ps = con.prepareStatement("SELECT Menu_tipoID,Nombre,Descripcion,Estado FROM Menu_tipo", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<MenuTipo> listarMenuTipo(){
        ArrayList<MenuTipo> listaMenuTipo = new ArrayList<MenuTipo>();
        try{
            this.cargarDatos();
            while(rs.next()){
                MenuTipo MenTip = new MenuTipo();
                MenTip.setMenu_tipoID(rs.getInt("Menu_tipoID"));
                MenTip.setNombre(rs.getString("Nombre"));
                MenTip.setDescripcion(rs.getString("Descripcion"));
                MenTip.setEstado(rs.getInt("Estado"));
                listaMenuTipo.add(MenTip);
            }
        }catch(SQLException e){
            System.out.println("Error en listarMenuTipo(): "+e.getMessage());
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
         return listaMenuTipo;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public MenuTipo getMenuTipoByID(int Menu_tipoID){
        MenuTipo menutipo = new MenuTipo();
        try{
            this.cargarDatos();
            while(rs.next()){
                if(Menu_tipoID==rs.getInt("Menu_tipoID")){
                    menutipo.setMenu_tipoID(rs.getInt("Menu_tipoID"));
                    menutipo.setNombre(rs.getString("Nombre"));
                    menutipo.setDescripcion(rs.getString("Descripcion"));
                    menutipo.setEstado(rs.getInt("Estado"));
                    
                    break;
                }
                
            }     
        }catch(SQLException e){
            System.out.println("El error en getMenuTipoByID(): "+e.getMessage());
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
        
        
        return menutipo;      
    }
     @SuppressWarnings("CallToPrintStackTrace")
    public boolean guardarMenuTipo (MenuTipo Ment)
    {
        //declaramos una bandera en falso
	boolean guardado = false;
	try {
            this.cargarDatos();
            rs.moveToInsertRow();            
            rs.updateString("Nombre", Ment.getNombre());
            rs.updateString("Descripcion", Ment.getDescripcion());
            rs.updateInt("Estado", Ment.getEstado());

            rs.insertRow();
            rs.moveToCurrentRow();
            //si el flujo llega hasta acá el registro se almacenó
            guardado = true; //hacemos verdadera la bandera
	}
	catch (SQLException e) {
            System.out.println("ERROR guardarMenuTipo(): "+e.getMessage());
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
    public boolean editarMenuTipo(MenuTipo Ment)
    {
        //declaramos una bandera en falso
	boolean resp=false;
        try
        {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Menu_tipoID")==(Ment.getMenu_tipoID())){
                   rs.updateString("Nombre", Ment.getNombre());
                   rs.updateString("Descripcion", Ment.getDescripcion());
                   rs.updateInt("Estado", Ment.getEstado());
                   rs.updateRow();
                    resp = true;
                    break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error en editarMenuTipo(): "+e.getMessage());
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
    public boolean deleteMenuTipo(MenuTipo Ment){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Menu_tipoID")==Ment.getMenu_tipoID()){
                    rs.deleteRow();
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error deleteMenuTipo(): "+e.getMessage());
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
    public boolean existeMenuTipo(MenuTipo Ment){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre").equals(Ment.getNombre())){
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeMenuTipo(): "+e.getMessage());
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

