/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cignusSoft.controlador;

import cignusSoft.bd.Conexion;
import java.sql.*;

/**
 *
 * @author chris
 */
public class ControladorSesion {
    
    //devuelve si el usuario existe o no
    public static int validarSesion(String nombre, String contrasenia){
        int identificador = 0;
        CallableStatement cst;
        Connection cn = null;
        try{
            cn = Conexion.getInstance().getConnection();
            cst = cn.prepareCall("{call validarUsuario(?,?,?)}");          
            cst.setString(1, nombre);
            cst.setString(2, contrasenia);
            
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cst.execute();
            
            identificador = cst.getInt(3);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return identificador;
    }
    
    public static void main(String[] args) {
        ControladorSesion cs = new ControladorSesion();
        
            int i;
            i = ControladorSesion.validarSesion("chris", "Milan123k22");
            System.out.println(i);
    }
}
