/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Jair Palaguachi
 * Clase cuentas con sus atributos y métodos correspondientes
 */
public abstract class Cuentas {
    private static int codigoCounter = 1;
    private int codigo;
    private Entidad entidad;
    private double valor;
    private String descripcion;
    private LocalDate fechaPrestamo;
    private double cuota;
    private LocalDate fechaInicioPago;
    private LocalDate fechaFinPago;

    /**
     * @param entidad representa una instancia de la Clase Entidad
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaPrestamo representa la fecha de prestamo
     * @param cuota representa la cuota en double
     * @param fechaInicioPago representa la fecha de inicio del pago
     * @param fechaFinPago representa la fecha de fin del pago
     */ 
    public Cuentas(Entidad entidad, double valor, String descripcion, LocalDate fechaPrestamo, double cuota, LocalDate fechaInicioPago, LocalDate fechaFinPago) {
        this.codigo = codigoCounter++;
        this.entidad = entidad;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fechaPrestamo = fechaPrestamo;
        this.cuota = cuota;
        this.fechaInicioPago = fechaInicioPago;
        this.fechaFinPago = fechaFinPago;
    }

    /**
     * @return codigo int que representa un codigo
     */ 
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return entidad  int que representa una entidad
     */ 
    public Entidad getEntidad() {
        return entidad;
    }

    /**
     * @return valor representa el valor en double
     */ 
    public double getValor() {
        return valor;
    }

    /**
     * @return descripcion representa una instancia de la entidad Categoria
     */ 
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return fechaPrestamo representa la fecha de prestamo
     */ 
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @return cuota representa la cuota en double
     */ 
    public double getCuota() {
        return cuota;
    }

    /**
     * @return fechaInicioPago representa la fecha de inicio del pago
     */ 
    public LocalDate getFechaInicioPago() {
        return fechaInicioPago;
    }

    /**
     * @return fechaFinPago representa la fecha de fin del pago
     */ 
    public LocalDate getFechaFinPago() {
        return fechaFinPago;
    }
    
    /**
     * @param codigo representa un codigo en formato int
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param entidad representa una instancia de la Clase Entidad
     */
    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    /**
     * @param valor representa el valor en double
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /**
     * @param descripcion representa una instancia de la entidad Categoria
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param fechaPrestamo representa la fecha de prestamo
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @param cuota representa la cuota en double
     */
    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    /**
     * @param fechaInicioPago representa la fecha de inicio del pago
     */
    public void setFechaInicioPago(LocalDate fechaInicioPago) {
        this.fechaInicioPago = fechaInicioPago;
    }

    /**
     * @param fechaFinPago representa la fecha de fin del pago
     */
    public void setFechaFinPago(LocalDate fechaFinPago) {
        this.fechaFinPago = fechaFinPago;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
    public abstract String toString();
    
    
  
}
