
package javaconsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexion {
    //contante para las conexiones
    private Connection conexion;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/factura";
    
    public void conectar () {
        
        conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,user,pass);
            if (conexion != null) {
                System.out.println("conectado!");
                
            }
        }
        catch (Exception e){
            
            System.err.println("error en la conexion" +e);
        }
    }
    
    public void consultarPersonas (){
        
        Statement instruccion;
        try {
            instruccion = conexion.createStatement();
            ResultSet resultados = instruccion.executeQuery("SELECT * FROM detalle");
            ResultSetMetaData metadatos = resultados.getMetaData();
            int columnas = metadatos.getColumnCount();
            
            for (int i = 1; i < columnas; i++) {
                System.out.print("--"+metadatos.getColumnName(i));
            }
            System.out.println("");
            while (resultados.next()){
                for (int i = 1; i < columnas; i++) {
                 System.out.print("--"+resultados.getObject(i));
                    
                }
                System.out.println(" ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}










