/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jairo Rodriguez
 * //Clase Persona con sus atributos y métodos correspondientes
 */
public class Persona extends Entidad{
    

    /**
     * @param rucId representa la cedula o ruc en formato String
     * @param nombre representa el nombre  en formato String
     * @param telefono representa el telefono en formato String
     * @param email representa la direccion en formato String
     * 
     */ 
    public Persona(String rucId, String nombre, String telefono, String email) {
        super(rucId, nombre, telefono, email);
    }

    /**
     * @return retorna un string
     */ 
    @Override
   public String toString(){
       return String.format("%-8d%-15s%-20s%-20s%-20s%-12s",
                super.getCodigo(), super.getFechaRegistro(), super.getRucId(), super.getNombre(), super.getEmail(),super.getOtrosDatos());
   }
}
