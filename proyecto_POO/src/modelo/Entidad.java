/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jairo Rodriguez
 * Clase Entidad con sus atributos y métodos correspondientes
 */
public abstract class Entidad {
    private static int codigoCounter = 1;
    private int codigo;
    private String fechaRegistro;
    private String rucId;
    private String nombre;
    private String telefono;
    private String email;
    
    
    /**
     * @param rucId representa la cedula o ruc en formato String
     * @param nombre representa el nombre  en formato String
     * @param telefono representa el telefono en formato String
     * @param email representa la direccion en formato String
     * 
     */ 

    public Entidad(String rucId, String nombre, String telefono, String email) {
        this.codigo = codigoCounter++;
        this.rucId = rucId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        this.fechaRegistro=fechaFormateada;
    }

    /**
     * @return fechaRegistro string que representa la fecha de registro
     */ 
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro string que representa la fecha de registro
     */ 
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    /**
     * @return codigo in que representa el codigo
     */ 
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo in que representa el codigo
     */ 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * @return rucId representa la cedula o ruc en formato String
     */ 
    public String getRucId() {
        return rucId;
    }

    /**
     * @return nombre representa el nombre  en formato String
     */ 
    public String getNombre() {
        return nombre;
    }

    /**
     * @return telefono representa el telefono en formato String
     */ 
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * @param telefono representa el telefono en formato String
     */ 
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * @return  telefono representa el telefono en formato String
     */ 
    public String getOtrosDatos() {
        return "Telf: "+telefono;
    }

    /**
     * @return  email representa la direccion en formato String
     * 
     */ 
    public String getEmail() {
        return email;
    }

    /**
     * @param rucId representa la cedula o ruc en formato String
     */ 
    public void setRucId(String rucId) {
        this.rucId = rucId;
    }

    /**
     * @param nombre representa el nombre  en formato String
     */ 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param email representa la direccion en formato String
     * 
     */ 
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return retorna un string
     */ 
    @Override
    public abstract String toString();
}
