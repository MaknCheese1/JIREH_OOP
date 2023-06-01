/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import datos.Conexion;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BEATRIZ
 */
public class Dt_Clientes {
    //Mis atributos
    private Connection con =  null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Creando metodos
      @SuppressWarnings("CallToPrintStackTrace")
    public void cargarDatos(){
        try{
            con = Conexion.getConnection(); //Obtendermos la conexion a la base de datos
            ps = con.prepareStatement("SELECT ClienteID ,RestauranteID ,Nombre_cliente,Telefono_cliente ,Direccion ,Estado FROM Cliente",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargar los datos():"+e.getMessage());
            e.printStackTrace();
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")

    public ArrayList<Cliente> listarCliente(){
        ArrayList<Cliente> listaClient = new ArrayList<Cliente>();
        try{
             this.cargarDatos();
             while(rs.next()){
                 Cliente client = new Cliente();
                 client.setClienteID(rs.getInt("ClienteID"));
                 client.setRestauranteID(rs.getInt("RestauranteID"));
                 client.setNombre_cliente(rs.getString("Nombre_cliente"));
                 client.setTelefono_cliente(rs.getString("Telefono_cliente"));
                 client.setDireccion(rs.getString("Direccion"));
                 client.setEstado(rs.getInt("Estado"));
                 listaClient.add(client);
             }
        }catch(SQLException e){
            System.out.println("Error en listarCliente"+e.getMessage());
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
        
        return listaClient;
        
    }
 @SuppressWarnings("CallToPrintStackTrace")
 public boolean guardarCliente(Cliente client){
     //Declarando una bandera en falso
     boolean guardado = false;
     try{
         this.cargarDatos();
         rs.moveToInsertRow();
         rs.updateInt("RestauranteID",client.getRestauranteID() );
         rs.updateString("Nombre_cliente", client.getNombre_cliente());
         rs.updateString("Telefono_cliente", client.getTelefono_cliente());
         rs.updateString("Direccion", client.getDireccion());
         rs.updateInt("Estado", client.getEstado());
         rs.insertRow();
         rs.moveToCurrentRow();
         //Si el flujo llega hasta aca, entonces el registro se almaceno
         guardado = true; //Hacemos verdadero la bandera
         
         
     }catch(SQLException e){
         System.out.println("Error guardarCliente():"+e.getMessage());
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
     return guardado;
 }
@SuppressWarnings("CallToPrintStackTrace")
 public boolean editarCliente(Cliente client){
     //Declaramos una bandera en falso
     boolean resp = false;
     try{
         this.cargarDatos();
         rs.beforeFirst();
         while(rs.next()){
             if(rs.getInt("ClienteID")==(client.getClienteID())){
                rs.updateInt("RestauranteID", client.getRestauranteID());
                rs.updateString("Nombre_cliente", client.getNombre_cliente());
                rs.updateString("Telefono_cliente",client.getTelefono_cliente());
                rs.updateString("Direccion",client.getDireccion());
                rs.updateInt("Estado", client.getEstado());
                rs.updateRow();
                resp = true;
                break;
             }
             
         }
         
     }catch(SQLException e){
         System.out.println("Error en editarCliente():"+e.getMessage());
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
            }catch (SQLException e){
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
         
     }
     return resp;
     
 }
@SuppressWarnings("CallToPrintStackTrace")
public boolean deleteCliente(Cliente client){
    boolean resp = false;
    try{
        this.cargarDatos();
        rs.beforeFirst();
        while(rs.next()){
            if(rs.getInt("ClienteID")==client.getClienteID())
             rs.deleteRow();
            resp=true;
        }
    }catch(SQLException e){
        System.out.println("Error en deleteCliente():"+e.getMessage());
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
public boolean existeCliente(Cliente client){
    boolean resp = false;
    try{
        this.cargarDatos();
        rs.beforeFirst();
        while(rs.next()){
            if(rs.getString("Nombre_cliente").equals(client.getNombre_cliente())){
                resp = true;
            }
            
        }
    }catch(SQLException e){
        System.out.println("Error en existeCliente:"+e.getMessage());
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
