/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elsner
 */
public class Dt_Proveedor {
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
            ps = con.prepareStatement("SELECT ProveedorID, RestauranteID, Nombre_proveedor, Telefono_proveedor, Correo_proveedor, Descripcion, Pagina_web FROM Proveedor", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Proveedor> listarProveedor(){
        ArrayList<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        try{
            this.cargarDatos();
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setProveedorID(rs.getInt("ProveedorID"));
                prov.setRestauranteID(rs.getInt("RestauranteID"));
                prov.setNombre_proveedor(rs.getString("Nombre_proveedor"));
                prov.setTelefono_proveedor(rs.getString("Telefono_proveedor"));
                prov.setCorreo_proveedor(rs.getString("Correo_proveedor"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setPagina_web(rs.getString("Pagina_web"));
                listaProveedor.add(prov);
            }
        }catch(SQLException e){
            System.out.println("Error en listarRestaurante(): "+e.getMessage());
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
         return listaProveedor;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean guardarProveedor (Proveedor prov)
    {
        //declaramos una bandera en falso
	boolean guardado = false;
	try {
            this.cargarDatos();
            rs.moveToInsertRow();
            rs.updateInt("RestauranteID", prov.getRestauranteID());
            rs.updateString("Nombre_proveedor", prov.getNombre_proveedor());
            rs.updateString("Telefono_proveedor", prov.getTelefono_proveedor());
            rs.updateString("Correo_proveedor", prov.getCorreo_proveedor());
            rs.updateString("Descripcion", prov.getDescripcion());
            rs.updateString("Pagina_web", prov.getPagina_web());
            rs.insertRow();
            rs.moveToCurrentRow();
            //si el flujo llega hasta acá el registro se almacenó
            guardado = true; //hacemos verdadera la bandera
	}
	catch (SQLException e) {
            System.out.println("ERROR guardarProveedor(): "+e.getMessage());
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
    public boolean editarProv(Proveedor prov)
    {
        //declaramos una bandera en falso
	boolean resp=false;
        try
        {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("ProveedorID")==(prov.getProveedorID())){
                    rs.updateInt("RestauranteID", prov.getRestauranteID());
                    rs.updateString("Nombre_proveedor", prov.getNombre_proveedor());
                    rs.updateString("Telefono_proveedor", prov.getTelefono_proveedor());
                    rs.updateString("Correo_proveedor", prov.getCorreo_proveedor());
                    rs.updateString("Descripcion", prov.getDescripcion());
                    rs.updateString("Pagina_web", prov.getPagina_web());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error en editarProv(): "+e.getMessage());
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
    public boolean deleteProv(Proveedor prov){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("ProveedorID")==prov.getProveedorID()){
                    rs.deleteRow();
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error deleteProv(): "+e.getMessage());
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
    public boolean existeProv(Proveedor prov){
	boolean resp=false;
        try {
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Nombre_proveedor").equals(prov.getNombre_proveedor())){
                    resp=true;
                }
            }	
	} 
        catch (SQLException e) {
            System.out.println("Error existeProveedor(): "+e.getMessage());
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






