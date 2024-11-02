/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.beans.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.dao.Conexion;
import java.util.Vector;

/**
 *
 * @author Seba_
 */
public class ProductoDAO {

    Connection con;
    Conexion objconexiona = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    //DefaultTableModel tableModel;

    public List listar() {
        List<Producto> Lista = new ArrayList<>();
        String sql = "Select * From Producto";
        try {
            //con=objconexiona.conectar();
            //ps =objconexiona.PrepareStatement(sql);
            rs = ps.executeQuery();
//            while (rs.next()) {
//            Producto p = new Producto();
//            p.setId(rs.getInt(1));
//            p.setNombre(rs.getString(2));
//            p.setPrecio(rs.getDouble(3));
//            p.setCantidad(rs.getInt(4));
//            Lista.add(p); 
            //}

        } catch (Exception e) {

        }
        return Lista;
    }

    public List<String> listar_tipo() {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "select distinct tipo from productos;";
            rs = st.executeQuery(querytxt);
            while (rs.next()) {
                valores.add(rs.getString("tipo"));

            }
        } catch (Exception e) {
        }

        return valores;

    }

    public List<String> listar_marca() {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "select distinct marca from productos;";
            rs = st.executeQuery(querytxt);
            while (rs.next()) {
                valores.add(rs.getString("marca"));

            }
        } catch (Exception e) {
        }

        return valores;

    }

    public DefaultTableModel listar_productos(DefaultTableModel tablemodel, String tipo, String marca) {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            if (tipo == "-") {
                if (marca == "-") {
                    querytxt = "select id,nombre, marca,precio_costo,ganancia_sugerida,stock from productos;";
                } else {
                    querytxt = "select id,nombre, marca,precio_costo,ganancia_sugerida,stock from productos where marca =\"" + marca + "\";";
                }
            } else {//tienes tipo
                if (marca == "-") {
                    querytxt = "select id,nombre, marca,precio_costo,ganancia_sugerida,stock from productos where tipo =\"" + tipo + "\";";
                } else {
                    querytxt = "select id,nombre, marca,precio_costo,ganancia_sugerida,stock from productos where tipo =\"" + tipo + "\" and marca =\"" + marca  + "\";";
                }
            }
            //querytxt = "select id,nombre, marca,precio_costo,ganancia,stock from productos;";
            rs = st.executeQuery(querytxt);
            // Obtener los metadatos de la consulta para obtener el número de columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            tablemodel.setRowCount(0);
            while (rs.next()) {
                valores.add(rs.getString("marca"));
                Vector<Object> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(rs.getObject(i));
                }
                tablemodel.addRow(rowData);

            }
        } catch (Exception e) {
        }

        return tablemodel;

    }
    
    public boolean modificar_producto(int idproducto,int columna, String valor) {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String campo="";
        switch (columna) {
            case 5:
                campo="stock";
                break;
            case 4:
                campo="ganancia_sugerida";
                break;
            case 3:
                campo="precio_costo";
                break;
            default:
                break;
        }
        
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "update productos set "+campo+" = "+valor+" where id = " + idproducto+";";
            st.executeUpdate(querytxt);
            System.out.print("producto actualizado a BD");
            return true;
        } catch (Exception e) {
            // Obtener mensaje de error
            String mensajeError = e.getMessage();
            System.out.print(mensajeError);
            return false;
        }
        //
        

    }
    
    public boolean eliminar_producto(int idproducto) {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        
        
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "delete from productos where id = " + idproducto+";";
            st.executeUpdate(querytxt);
            System.out.print("producto eliminado a BD");
            return true;
        } catch (Exception e) {
            // Obtener mensaje de error
            String mensajeError = e.getMessage();
            System.out.print(mensajeError);
            return false;
        }
        //
        

    }
    
    public boolean ingresar_producto(Producto prod) {

        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            querytxt = "insert into productos (nombre, marca, tipo, precio_costo, ganancia_sugerida,stock) "
                    + "values (\""
                    + prod.getNombre() + "\",\""
                    + prod.getMarca() + "\",\""
                    + prod.getTipo() + "\","
                    + prod.getPrecio_costo() + ","
                    + prod.getGanancia_sugerida() + ","
                    + prod.getStock()  + ");";
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
    
    public DefaultTableModel busqueda_productos(DefaultTableModel tablemodel, String nombre) {

        List<String> valores = new ArrayList<>();
        Conexion objconexiona = new Conexion();
        objconexiona.establecer();
        Statement st;
        ResultSet rs;
        String cadena, querytxt;
        try {
            st = objconexiona.conectar.createStatement();
            
            querytxt = "select id,nombre, marca,precio_costo+ganancia_sugerida from productos where nombre like\""+nombre+"%\";";
            rs = st.executeQuery(querytxt);
            // Obtener los metadatos de la consulta para obtener el número de columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            tablemodel.setRowCount(0);
            while (rs.next()) {
                valores.add(rs.getString("marca"));
                Vector<Object> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(rs.getObject(i));
                }
                tablemodel.addRow(rowData);

            }
        } catch (Exception e) {
        }

        return tablemodel;

    }

}
