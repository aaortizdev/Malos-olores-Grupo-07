/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

/**
 *
 * @author Jair Palaguachi
 * Clase Gasto con sus atributos y métodos correspondientes
 */
/**
     * @param fechaInicio representa la fecha de inicio 
     * @param categoria representa una instancia de la entidad Categoria
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaFin representa la fecha de fin
     * @param repeticion representa una instancia de la entidad Repeticion
     */  
public class Gasto extends Transaccion {
    public Gasto(LocalDate fechaInicio, Categoria categoria, double valor, String descripcion, LocalDate fechaFin, Repeticion repeticion){
        super(fechaInicio,categoria,valor,descripcion,fechaFin,repeticion);
    }
}
