/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author Seba_
 */
public class Producto {
    int id;
    String nombre;
    String marca;
    String tipo;
    double precio_costo;
    int ganancia_sugerida;
    int stock;

    public Producto(int id, String nombre, String marca, String tipo, double precio_costo, int ganancia_sugerida, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precio_costo = precio_costo;
        this.ganancia_sugerida = ganancia_sugerida;
        this.stock = stock;
    }

    public Producto(String nombre, String marca, String tipo, double precio_costo, int ganancia_sugerida, int stock) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precio_costo = precio_costo;
        this.ganancia_sugerida = ganancia_sugerida;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getGanancia_sugerida() {
        return ganancia_sugerida;
    }

    public void setGanancia_sugerida(int ganancia_sugerida) {
        this.ganancia_sugerida = ganancia_sugerida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
}
