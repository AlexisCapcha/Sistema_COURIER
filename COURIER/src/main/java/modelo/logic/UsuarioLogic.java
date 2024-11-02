/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import modelo.dao.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.beans.Usuario;
import modelo.dao.UsuarioDao;

/**
 *
 * author
 */
public class UsuarioLogic {
   private static UsuarioDao usuarioDao = new UsuarioDao();

    public static boolean autentificador(String usuario, String contraseña) {
        Usuario usuarioConsulta = obtener(usuario);
        
        if (usuarioConsulta != null && usuarioConsulta.getNumeroDocumento().equals(usuario) && usuarioConsulta.getClave().equals(contraseña)) {
            return true; 
        } else {
            return false; 
        }
    }

    public static boolean insertar(Usuario usuario) {
        return usuarioDao.insertar(usuario);
    }

    public static boolean modificar(Usuario usuario) {
        return usuarioDao.modificar(usuario);
    }

    public static boolean eliminar(String nombreUsuario) {
        return usuarioDao.eliminar(nombreUsuario);
    }

    public static Usuario obtener(String usuario) {
        return usuarioDao.obtener(usuario);
    }

}
