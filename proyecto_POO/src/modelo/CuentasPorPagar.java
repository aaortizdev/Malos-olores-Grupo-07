/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

/**
 *
 * @author Jair Palaguachi
 * Clase CuentasPorPagar con sus atributos y métodos correspondientes
 */
public class CuentasPorPagar extends Cuentas {
    private String RucId;
    private double interes;

    /**
     * @return RucId string que representa una cedula o ruc
     */ 
    public String getRucId() {
        return RucId;
    }

    /**
     * @return interes double que representa un interes
     */ 
    public double getInteres() {
        return interes;
    }

    /**
     * @param  RucId string que representa una cedula o ruc
     */ 
    public void setRucId(String RucId) {
        this.RucId = RucId;
    }
    
    /**
     * @param  interes double que representa un interes
     */ 
    public void setInteres(double interes) {
        this.interes = interes;
    }

    /**
     * @param entidad representa una instancia de la Clase Entidad
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaPrestamo representa la fecha de prestamo
     * @param cuota representa la cuota en double
     * @param fechaInicioPago representa la fecha de inicio del pago
     * @param fechaFinPago representa la fecha de fin del pago
     * @param RucId representa el ruc o cedula en formato string
     * @param interes representa el interes en formato double
     */ 
    public CuentasPorPagar(Entidad entidad, double valor, String descripcion, LocalDate fechaPrestamo, double cuota, LocalDate fechaInicioPago, LocalDate fechaFinPago,String RucId,double interes) {
    
        super(entidad, valor, descripcion, fechaPrestamo, cuota, fechaInicioPago, fechaFinPago);
        this.RucId=RucId;
        this.interes=interes;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
   public String toString(){
       return String.format("%-8d%-15s%-15.2f%-20s%-20s%-20.2f%-20s%-20s%-20s%-12.2f",
                super.getCodigo(),super.getEntidad().getNombre(), super.getValor(), super.getDescripcion(), super.getFechaPrestamo(), super.getCuota(),super.getFechaInicioPago(),super.getFechaFinPago(),this.getRucId(),this.getInteres());
   }
   
}
