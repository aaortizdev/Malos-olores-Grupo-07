/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;


/**
 *
 * @author Josue Esparza
 * Clase Transaccion con sus atributos y métodos correspondientes
 */
public abstract class Transaccion {
    private static int codigoCounter = 1;
    private int codigo;
    private LocalDate fechaInicio;
    private Categoria categoria;
    private double valor;
    private String descripcion;
    private LocalDate fechaFin;
    private Repeticion repeticion;

    /**
     * @param fechaInicio representa la fecha de inicio 
     * @param categoria representa una instancia de la entidad Categoria
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaFin representa la fecha de fin
     * @param repeticion representa una instancia de la entidad Repeticion
     */  
    public Transaccion(LocalDate fechaInicio, Categoria categoria, double valor, String descripcion, LocalDate fechaFin, Repeticion repeticion) {
        this.codigo = codigoCounter++;
        this.fechaInicio = fechaInicio;
        this.categoria = categoria;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.repeticion = repeticion;
    }

    /**
     * @return codigo in que representa el codigo
     */ 
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return fechaInicio representa la fecha de inicio 
     */ 
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return categoria representa una instancia de la entidad Categoria
     */ 
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @return  valor representa el valor en double
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
     * @return fechaFin representa la fecha de fin
     */ 
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * @return  repeticion representa una instancia de la entidad Repeticion
     */ 
    public Repeticion getRepeticion() {
        return repeticion;
    }

    /**
     * @param fechaFin representa la fecha de fin
     */ 
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
     public String toString() {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //String fechaInicioStr = sdf.format(fechaInicio);
        return String.format("%-12d%-15s%-14s%-15.2f%-20s%-12s%-12s",
                codigo, fechaInicio, categoria.getNombre(), valor, descripcion, fechaFin, repeticion);
    }
}
