/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import modelo.dao.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Producto;
import modelo.dao.ProductoDAO;

/**
 *
 * author
 */
public class ProductoLogic {
   private static ProductoDAO productoDao = new ProductoDAO();

    

    public static List<String> listar_tipo() {
        return productoDao.listar_tipo();
    }
    
    public static List<String> listar_marca() {
        return productoDao.listar_marca();
    }
    
    public static DefaultTableModel listar_productos(DefaultTableModel tablemodel, String tipo, String marca) {
        return productoDao.listar_productos(tablemodel,tipo,marca);
    }
    public static boolean modificar_producto(int idproducto,int columna, String valor) {
        return productoDao.modificar_producto(idproducto,columna,valor);
    }
    
    public static boolean eliminar_producto(int idproducto) {
        return productoDao.eliminar_producto(idproducto);
    }
    public static boolean ingresar_producto(Producto prod) {
        return productoDao.ingresar_producto(prod);
    }
    public static DefaultTableModel busqueda_productos(DefaultTableModel tablemodel, String nombre) {
        return productoDao.busqueda_productos(tablemodel,nombre);
    }

 

}
