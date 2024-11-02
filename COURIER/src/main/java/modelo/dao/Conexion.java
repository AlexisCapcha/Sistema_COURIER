/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection conectar = null;
    String usuario = "root";
    String password = "root";
    String bd = "sistema";
    String ip ="192.168.1.6";
    String puerto = "3306";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecer(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,password);
            System.out.println("Conectado");
        
        } catch (Exception e){
        
            System.out.println("Error: "+e.toString());
        }   
        return conectar;
    }
    
}
