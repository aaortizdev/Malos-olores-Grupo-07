/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jair Palaguachi
 * Clase Proyeccion usada para los reportes de Proyeccion de Gastos
 */
public class Proyeccion {
    private String categoria;
    private double valor;

 /**
     * @param categoria String que representa una categoria
     * @param valor double que representa el valor de una proyeccion
     * 
     */   
    public Proyeccion(String categoria, double valor) {
        this.categoria = categoria;
        this.valor = valor;
    }

    /**
     * @return categoria String que representa una categoria
     * 
     */  
    public String getCategoria() {
        return categoria;
    }
    
    /**
     * @return valor String que double que representa el valor de una proyeccion
     * 
     */  

    public double getValor() {
        return valor;
    }
    
    /**
     * @param categoria String que representa una categoria
     * 
     */   

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @param valor double que representa el valor de una proyeccion
     * 
     */   
    public void setValor(double valor) {
        this.valor = valor;
    }

   
    
    
}
