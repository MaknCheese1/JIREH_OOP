/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import datos.Conexion;
import entidades.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elsner
 */
public class Dt_Restaurante {
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
            ps = con.prepareStatement("SELECT RestauranteID ,Nombre_restaurante ,Telefono_restaurante ,Correo_restaurante ,Direccion ,Numero_ruc ,Pagina_web FROM Restaurante", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error en cargarDatos(): "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Restaurante> listarRestaurante(){
        ArrayList<Restaurante> listaRestaurante = new ArrayList<Restaurante>();
        try{
            this.cargarDatos();
            while(rs.next()){
                Restaurante rest = new Restaurante();
                rest.setRestauranteID(rs.getInt("RestauranteID"));
                rest.setNombre_restaurante(rs.getString("Nombre_restaurante"));
                rest.setTelefono_restaurante(rs.getString("Telefono_restaurante"));
                rest.setCorreo_restaurante(rs.getString("Correo_restaurante"));
                rest.setDireccion(rs.getString("Direccion"));
                rest.setNumero_ruc(rs.getString("Numero_ruc"));
                rest.setPagina_web(rs.getString("Pagina_web"));
                listaRestaurante.add(rest);
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
         return listaRestaurante;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean guardarRestaurante(Restaurante re){
        boolean guardado = false;
        try{
            this.cargarDatos();
            rs.moveToInsertRow();
            
            rs.updateString("Nombre_restaurante", re.getNombre_restaurante());
            rs.updateString("Telefono_restaurante", re.getTelefono_restaurante());
            rs.updateString("Correo_restaurante", re.getCorreo_restaurante());
            rs.updateString("Direccion", re.getDireccion());
            rs.updateString("Numero_ruc", re.getNumero_ruc());
            rs.updateString("Pagina_web", re.getPagina_web());
            rs.insertRow();
            rs.moveToCurrentRow();
            //En donde si el flujo llega hasta aca el registro se almacenara correctamente
            guardado = true;
            
        }catch(SQLException e){
          System.out.println("Error guardarRestaurante"+e.getMessage());
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

    public boolean editarRestaurante(Restaurante re){
        boolean resp = false;
        try{
          this.cargarDatos();
          rs.beforeFirst();
          while(rs.next()){
              if(rs.getInt("RestauranteID")==(re.getRestauranteID())){

                  rs.updateString("Nombre_restaurante", re.getNombre_restaurante());
                  rs.updateString("Telefono_restaurante", re.getTelefono_restaurante());
                  rs.updateString("Correo_restaurante", re.getCorreo_restaurante());
                  rs.updateString("Direccion", re.getDireccion());
                  rs.updateString("Numero_ruc", re.getNumero_ruc());
                  rs.updateString("Pagina_web", re.getPagina_web());
                  resp = true;
                  break;
              }
          }
        }catch(SQLException e){
            System.out.println("Error en editarRestaurante()"+e.getMessage());
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
    public boolean deleteRestaurante(Restaurante re){
        boolean resp = false;
        try{
            this.cargarDatos();
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("RestauranteID")==re.getRestauranteID()){
                    rs.deleteRow();
                    resp=true;
                }
            }
        }catch(SQLException e){
            System.out.println("Error deleteRestaurante():"+e.getMessage());
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
  public boolean existeRestaurante(Restaurante re){
      boolean resp = false;
      try{
          this.cargarDatos();
          rs.beforeFirst();
          while(rs.next()){
              if(rs.getString("Nombre_restaurante").equals(re.getNombre_restaurante())){
                  resp=true;
              }
          }
      }catch(SQLException e){
          System.out.println("Error en existeRestaurante():"+e.getMessage());
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

