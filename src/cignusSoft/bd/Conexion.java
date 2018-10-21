/*
    Esta clase crea una conexión a la base de datos en mysql usando el patrón
    de diseño singleton para devolver una única instancia.
*/
package cignusSoft.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class Conexion {
    //Instanciamos una variable de la misma clase
    private static Conexion _Instance;
    //Instanciamos las variables para la conexion
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BD = "puntoVenta";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;
    private static final String USUARIO = "chris";  //establece el nombre del usuario
    private static final String CONTRASENIA = "milan";  //establece la contraseña de la conexión
    
    //declaramos el constructor como privado para impedir su acceso
    private Conexion(){}
    
    //método que devuelve la conexión
    public static Conexion getInstance(){
        if(_Instance == null){
            _Instance = new Conexion();
            return _Instance;
        }
        else{
            return _Instance;
        }
    }
    
    //método que realiza la conexion con la base de datos
    public static Connection getConnection(){
        Connection cn = null;        
        try {
            Class.forName(DRIVER);            
            cn = DriverManager.getConnection(URL, USUARIO,CONTRASENIA);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return cn;
    }
}
