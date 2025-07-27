/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josue Esparza
 * //Clase Categoria con sus atributos y métodos correspondientes
 */
public class Categoria {
     private static int codigoCounter = 1;
    private int codigo;
    private String nombre;
    private TipoCategoria tipo;

    /**
     * @param nombre String que identifica el nombre de una categoria
     * @param tipo String que identifica el tipo de una categoria
     *
     */ 
    public Categoria(String nombre, TipoCategoria tipo) {
        this.codigo = codigoCounter++;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * @return codigo int que representa el codigo
     */ 
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * @return nombre String que representa el nombre
     */ 

    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return tipo instancia de la entidad TipoCategoria
     */ 


    public TipoCategoria getTipo() {
        return tipo;
    }
    
    /**
     * @param nombre String que identifica el nombre de una categoria
     *
     */ 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return retorna un string
     */ 
     @Override
    public String toString(){
      return "Categoria [Nombre=" + this.nombre + ", Tipo=" + this.tipo +"]";
}
}
