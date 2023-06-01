/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Elsner
 */
import java.sql.*;

public class Conexion {
    
    //atributos
    private static Conexion conx = null;
    private static Connection con = null;
    private static String url = "jdbc:sqlserver://localhost;databaseName=JirehDB;Persist Security Info=True;";
    private static String user = "sa";
    private static String password = "1234";
    public  static Statement sentencia;
    public  static ResultSet resultado;
    
     
    private Conexion() {
        
    }
    
    public static Conexion getInstance(){
        //instanciamos la unica instancia de Conexion
        if(conx==null){
            conx = new Conexion();
        }
        return conx;
    }
    //metodos
    public static Connection getConnection() {	
        if (estaConectado()==false) {
            Conexion.crearConexion();
            
        }
        return con; 
    }
   
    @SuppressWarnings("UseSpecificCatch")
    public static boolean estaConectado()
    {
        boolean resp = false;
        try{
            if ((con==null) || (con.isClosed())){
                resp = false;
            }
            else{
                resp = true;
            }                 
        }
        catch(Exception e){
            System.out.println("Error al consultar el estado de la conexion: "+e.getMessage());
        }
        return resp;
    }
   
    public static void crearConexion()
    {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con= DriverManager.getConnection(url, user, password);
           System.out.println("Se conectó a la BD Jireh");
           sentencia = con.createStatement();
        } 
        catch (ClassNotFoundException e) {
           con=null;
           System.out.println("Error al cargar el driver:" +e.getMessage());
        } 
        catch (SQLException e) {
           con=null;
           System.out.println("Error al establecer la conexion:" +e.getMessage());
       }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void closeConexion(Connection con){
        if(estaConectado()!=false){
            try{
                sentencia.close();
                con.close();
                System.out.println("Cerrando la conexion");
            }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
    }
   
    public static void main(String args[])
    {
           // Probando la clase de conexion
            new Conexion().getConnection();
        
    }

}
