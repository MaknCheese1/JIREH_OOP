/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mariano Lacayo
 */
public class Dt_Usuario {
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
            ps = con.prepareStatement("SELECT UsuarioID, RolID, Nombre_usuario, clave, Estado FROM Usuario", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Usuario> listarUser(){
        ArrayList<Usuario> listUser = new ArrayList<Usuario>();
        try{
            this.cargarDatos();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setUsuarioID(rs.getInt("UsuarioID"));
                u.setRolID(rs.getInt("RolID"));
                u.setNombre_usuario(rs.getString("Nombre_usuario"));
                u.setClave(rs.getString("Clave"));
                u.setEstado(rs.getInt("Estado"));
                listUser.add(u);
            }     
        }catch(SQLException e){
            System.out.println("El error en listarUser(): "+e.getMessage());
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
        
        
        return listUser;      
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean guardarUser (Usuario user)
    {
        //declaramos una bandera en falso
	boolean guardado = false;
	try {
            this.cargarDatos();
            rs.moveToInsertRow();
            rs.updateString("Nombre_usuario", user.getNombre_usuario());
            rs.updateString("Clave", user.getClave());
            rs.updateInt("Estado", user.getEstado());
            rs.updateInt("RolID", user.getRolID());
            rs.insertRow();
            rs.moveToCurrentRow();
            //si el flujo llega hasta acá el registro se almacenó
            guardado = true; //hacemos verdadera la bandera
	}
	catch (SQLException e) {
            System.out.println("ERROR guardarUser(): "+e.getMessage());
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
    public boolean existeUsuario(String u){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre_usuario").equals("u")){
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeUsuario(): "+e.getMessage());
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
    public boolean editarUsuario(Usuario u)
    {
	boolean resp=false;
        try
        {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("UsuarioID")==(u.getUsuarioID())){
                   rs.updateString("Nombre_usuario", u.getNombre_usuario());
                   rs.updateString("Clave", u.getClave());
                   rs.updateInt("Estado", u.getEstado());
                   rs.updateInt("RolID", u.getRolID());
                   rs.updateRow();
                    resp = true;
                    break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error en editarUsuario(): "+e.getMessage());
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
    public boolean deleteUser(int id){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("UsuarioID")==id){
                    rs.deleteRow();
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeUsuario(): "+e.getMessage());
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
    public Usuario getUsuario(String user){
        Usuario us = new Usuario();
        try{
            this.cargarDatos();
            while(rs.next()){
                if(rs.getString("Nombre_usuario").equals(user)){
                    us.setUsuarioID(rs.getInt("UsuarioID"));
                    us.setRolID(rs.getInt("RolID"));
                    us.setNombre_usuario(rs.getString("Nombre_usuario"));
                    us.setClave(rs.getString("Clave"));
                    us.setEstado(rs.getInt("Estado"));
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
        
        
        return us;      
    }
    
     @SuppressWarnings("CallToPrintStackTrace")
    public boolean validarUsuario(String user, String pwd){
	boolean acceso=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre_usuario").equals(user) && rs.getString("clave").equals(pwd)){
                    acceso=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error validarUsuario(): "+e.getMessage());
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
		
        return acceso;
    }
}
