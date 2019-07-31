
package javaconsql;


public class Javaconsql {

    
    public static void main(String[] args) {
        
        conexion conexion = new conexion();
        conexion.conectar();
        conexion.consultarPersonas();
    }
    
}



