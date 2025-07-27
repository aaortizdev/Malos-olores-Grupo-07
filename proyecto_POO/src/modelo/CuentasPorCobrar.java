/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Jair Palaguachi
 * Clase CuentasPorCobrar con sus atributos y métodos correspondientes
 */
public class CuentasPorCobrar extends Cuentas {
  
    private String cedula;

    /**
     * @return cedula string que representa una cedula
     */ 
    public String getCedula() {
        return cedula;
    }
    
    /**
     * @param cedula string que representa una cedula
     */ 

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    /**
     * @param entidad representa una instancia de la Clase Entidad
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaPrestamo representa la fecha de prestamo
     * @param cuota representa la cuota en double
     * @param fechaInicioPago representa la fecha de inicio del pago
     * @param fechaFinPago representa la fecha de fin del pago
     * @param cedula representa la cedulaen formato String
     */ 
    public CuentasPorCobrar(Entidad entidad, double valor, String descripcion, LocalDate fechaPrestamo, double cuota, LocalDate fechaInicioPago, LocalDate fechaFinPago,String cedula) {
    
        super(entidad, valor, descripcion, fechaPrestamo, cuota, fechaInicioPago, fechaFinPago);
        this.cedula=cedula;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
   public String toString(){
       return String.format("%-8d%-15s%-15.2f%-20s%-20s%-20.2f%-20s%-20s%-20s",
                super.getCodigo(),super.getEntidad().getNombre(), super.getValor(), super.getDescripcion(), super.getFechaPrestamo(), super.getCuota(),super.getFechaInicioPago(),super.getFechaFinPago(),this.getCedula());
   }
   

   

}
