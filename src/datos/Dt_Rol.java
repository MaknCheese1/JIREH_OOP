/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mariano Lacayo
 */
public class Dt_Rol {
    //atributos
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //metodos
    @SuppressWarnings("CallToPrintStackTrace")
    public void cargarDatos()
    {
        try{
            con = Conexion.getConnection();
            ps = con.prepareStatement("SELECT RolID, Rol_nombre, Estado  FROM Rol", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public Rol getRolByID(int RolID){
        Rol rol = new Rol();
        try{
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("RolID")==RolID){
                    rol.setRolID(RolID);
                    rol.setRol_nombre(rs.getString("Rol_nombre"));
                    rol.setEstado(rs.getInt("Estado"));
                    
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
         
        return rol;      
    }
    
     @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Rol> listarRol(){
        ArrayList<Rol> listRol = new ArrayList<Rol>();
        try{
            this.cargarDatos();
            while(rs.next()){
                Rol r = new Rol();
                r.setRolID(rs.getInt("RolID"));
                r.setRol_nombre(rs.getString("Rol_nombre"));
                r.setEstado(rs.getInt("Estado"));
                listRol.add(r);
            }
        }catch(SQLException e){
            System.out.println("Error en listarRol(): "+e.getMessage());
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
         return listRol;
    }
}
