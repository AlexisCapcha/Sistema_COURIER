/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Usuario;
import modelo.dao.Conexion;

/**
 *
 * @author
 */
public class UsuarioDao {

    private List<Usuario> usuarios;

    public UsuarioDao() {
        usuarios = new ArrayList<>();
    }

    public int buscar(String usuario) {
        int n = -1;
//        for (int i = 0; i < usuarios.size(); i++) {
//            if (usuarios.get(i).getNombreUsuario().equals(usuario)) {
//                n = i;
//                break;
//            }
//        }
        return n;
    }

    public boolean insertar(Usuario usuario) {

        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "insert into users (tipo_documento, numero_documento, nombre, segundo_nombre, tercer_nombre,apellido_paterno,apellido_materno,correo,celular,nacionalidad,fecha_nacimiento,clave) "
                    + "values (\""
                    + usuario.getTipoDocumento() + "\",\""
                    + usuario.getNumeroDocumento() + "\",\""
                    + usuario.getNombre() + "\",\""
                    + usuario.getSegundoNombre() + "\",\""
                    + usuario.getTercerNombre() + "\",\""
                    + usuario.getApellidoPaterno() + "\",\""
                    + usuario.getApellidoPaterno() + "\",\""
                    + usuario.getCorreo() + "\",\""
                    + usuario.getCelular() + "\",\""
                    + usuario.getNacionalidad() + "\",\""
                    + usuario.getFechaNacimiento() + "\",\""
                    + usuario.getClave() + "\");";
            st.executeUpdate(querytxt);
            System.out.print("usuario ingresado a BD");
            return true;
        } catch (Exception e) {
            // Obtener mensaje de error
            String mensajeError = e.getMessage();
            System.out.print(mensajeError);
            return false;
        }

    }

    public boolean modificar(Usuario usuario) {
//        int indice = buscar(usuario.getNombreUsuario());
//        if (indice != -1) {
//            Usuario usuarioAux = usuarios.get(indice);
//            usuarioAux.setContraseña(usuario.getContraseña());
//            usuarioAux.setNombre(usuario.getNombre());
//            usuarioAux.setApellido(usuario.getApellido());
//            usuarioAux.setCorreo(usuario.getCorreo());
//            return true;
//        } else {
        return false;
//        }
    }

    public boolean eliminar(String usuario) {
        int indice = buscar(usuario);
        if (indice != -1) {
            usuarios.remove(indice);
            return true;
        } else {
            return false;
        }
    }

    public Usuario obtener(String usuario) {

        //Conexion objconexion = new Conexion();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "select numero_documento,clave from users where numero_documento =\"" + usuario + "\";";
            rs = st.executeQuery(querytxt);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNumeroDocumento(rs.getString("numero_documento"));
                u.setClave(rs.getString("clave"));
                cadena = "user: " + rs.getString("numero_documento");
                cadena += "|clave " + rs.getString("clave");
                System.out.println(cadena);
                return u;

            }
        } catch (Exception e) {
        }

        return null;
    }

}
