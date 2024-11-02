/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoIndividuales;

import java.awt.event.ActionEvent;

/**
 *
 * @author victor
 */
public class Trabajador {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getAñostrabajo() {
        return añostrabajo;
    }

    public void setAñostrabajo(int añostrabajo) {
        this.añostrabajo = añostrabajo;
    }
    
    private String nombre;
    private String apellido;
    private int sueldo;
    private int añostrabajo;
    
    public void mostrar (){
        System.out.println("Nombre: ");
    }

    public void popupMenu1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
}
