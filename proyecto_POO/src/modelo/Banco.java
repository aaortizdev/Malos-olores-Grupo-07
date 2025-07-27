/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jairo Rodriguez
 * Clase Banco con sus atributos y métodos correspondientes
 */
public class Banco extends Entidad{
    private String nombreOficialCredito;
    private String telefonoOficialCredito;
    
    /**
     * @param ci representa la cedula en formato String
     * @param nombre representa el nombre  en formato String
     * @param telefono representa el telefono en formato String
     * @param direccion representa la direccion en formato String
     * @param nombreOficialCredito representa el nombre de un oficial de credito en formato String
     * @param telefonoOficialCredito representa el telefono de un oficial de credito en formato String
     * 
     */ 
    public Banco(String rucId, String nombre, String telefono, String email, String nombreOficialCredito, String telefonoOficialCredito) {
        super(rucId, nombre, telefono, email);
        this.nombreOficialCredito = nombreOficialCredito;
        this.telefonoOficialCredito = telefonoOficialCredito;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
    public String getOtrosDatos() {
        return "Oficial: "+this.getNombreOficialCredito()+"   Telf: "+this.getTelefonoOficialCredito() ;
    }

    /**
     * @return nombreOficialCredito representa el nombre de un oficial de credito en formato String
     */ 
    
    public String getNombreOficialCredito() {
        return nombreOficialCredito;
    }
    
    /**
     * @return telefonoOficialCredito representa el telefono de un oficial de credito en formato String
     */ 

    public String getTelefonoOficialCredito() {
        return telefonoOficialCredito;
    }
    
    /**
     * @return retorna un string
     */ 
    
    @Override
   public String toString(){
       return String.format("%-8d%-15s%-20s%-25s%-30s%-12s",
                super.getCodigo(), super.getFechaRegistro(), super.getRucId(), super.getNombre(), super.getEmail(),this.getOtrosDatos());
   }
}
