/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.sql.ResultSet;
import java.sql.Statement;
import modelo.dao.Conexion;

public class Usuario {

    private String tipoDocumento; // DNI, CE
    private String numeroDocumento;
    
    private String nombre;
    private String segundoNombre; 
    private String tercerNombre;

    private String apellidoPaterno;
    private String apellidoMaterno;

    private String correo;
    private String celular;
    
    private String nacionalidad; // ComboBox para seleccionar
    
    private String fechaNacimiento;
    private String clave;

    public Usuario(String tipoDocumento, String numeroDocumento, String nombre, String segundoNombre, String tercerNombre,String apellidoPaterno,String apellidoMaterno,String correo,
            String celular,String nacionalidad,String fechaNacimiento,String clave) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.tercerNombre = tercerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.celular = celular;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.clave = clave;
        System.out.println(numeroDocumento + clave);
    }

    public Usuario() {
        
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean validaClave(String clave) {

    if (clave.length() < 4) {
        return false; 
    }
        
    boolean tieneNumero = false;
    boolean tieneMayuscula = false;
    
    for (char c : clave.toCharArray()) {
        if (Character.isDigit(c)) {  
            tieneNumero = true;
        }
        if (Character.isUpperCase(c)) {
            tieneMayuscula = true;
        }
    }
    
    return (tieneNumero && tieneMayuscula); 
}

}
