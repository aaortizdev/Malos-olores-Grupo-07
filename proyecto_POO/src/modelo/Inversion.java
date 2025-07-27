/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Julio Llerena
 * Clase Inversion con sus atributos y métodos correspondientes
 */
public class Inversion {
    private static int codigoCounter = 1;
    private int codigo;
    private Banco banco;
    private LocalDate fechaApertura;
    private double cantidad;
    private double interesMensual;
    private LocalDate fechaFinalizacion;
    
    /**
     * @param banco representa una instancia de la entidad Banco
     * @param fechaApertura representa la fecha de apertura
     * @param cantidad representa la cantidad de inversion en formato double
     * @param interesMensual representa el interes mensual en formato double
     * @param fechaFinalizacion representa la fecha de finalizacion
     * 
     */ 

    public Inversion(Banco banco, LocalDate fechaApertura, double cantidad, double interesMensual, LocalDate fechaFinalizacion) {
        this.codigo = codigoCounter++;
        this.banco = banco;
        this.fechaApertura = fechaApertura;
        this.cantidad = cantidad;
        this.interesMensual = interesMensual;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    /**
     * @return codigo in que representa el codigo
     */ 
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return banco representa una instancia de la entidad Banco
     * 
     */ 
    public Banco getBanco() {
        return banco;
    }

    /**
     * @return fechaApertura representa la fecha de apertura
     */ 
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    
    /**
     * @return  cantidad representa la cantidad de inversion en formato double
     */ 

    public double getCantidad() {
        return cantidad;
    }
    
    /**
     * @return interesMensual representa el interes mensual en formato double
     * 
     */ 

    public double getInteresMensual() {
        return interesMensual;
    }

    /**
     * @return  fechaFinalizacion representa la fecha de finalizacion
     * 
     */ 
    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
     public String toString() {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //String fechaInicioStr = sdf.format(fechaInicio);
        //%-10s%-23s%-20s%-20s%-20s%-20s
        return String.format("%-10d%-23s%-20s%-20.2f%-20.2f%-20s\n", this.getCodigo(), this.getBanco().getNombre(), this.getFechaApertura(),this.getCantidad(),this.getInteresMensual(), this.getFechaFinalizacion());
    }

}
