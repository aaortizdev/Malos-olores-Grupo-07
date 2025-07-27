/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Jair Palaguachi
 * Clase CuentaBancaria con sus atributos y métodos correspondientes
 */
public class CuentaBancaria {
    private static int codigoCounter = 1;
    private int codigo;
    private Banco banco;
    private String numero;
    private TipoCuenta tipo;
    private LocalDate fechaApertura;
    private double saldo;
    private double interesMensual;
    private LocalDate fechaCierre;

    /**
     * @param banco representa una instancia de la entidad Banco
     * @param numero representa el numero de cuenta en formato String
     * @param tipo representa una instancia de la entidad TipoCuenta
     * @param fechaApertura representa la fecha de apertura
     * @param saldo representa el saldo en double
     * @param interesMensual representa el interes mensual en formato double
     * @param fechaCierre representa la fecha de cierre
     * 
     */ 
    public CuentaBancaria(Banco banco, String numero, TipoCuenta tipo, LocalDate fechaApertura, double saldo, double interesMensual,LocalDate fechaCierre) {
        this.codigo = codigoCounter++;
        this.banco = banco;
        this.numero = numero;
        this.tipo = tipo;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.interesMensual = interesMensual;
        this.fechaCierre=fechaCierre;
    }
    
    /**
     * @return codigo int que representa un codigo
     */ 

    public int getCodigo() {
        return codigo;
    }

    /**
     * @return banco que representa una instancia de la entidad Banco
     */ 
    public Banco getBanco() {
        return banco;
    }
    
    /**
     * @return numero string que representa un numero
     */ 

    public String getNumero() {
        return numero;
    }
    
    /**
     * @return tipo que representa una instancia de la entidad TipoCuenta
     */ 

    public TipoCuenta getTipo() {
        return tipo;
    }
    
    /**
     * @return fechaApertura representa la fecha de apertura
     */ 

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    
    /**
     * @return saldo representa el saldo en double
     */ 

    public double getSaldo() {
        return saldo;
    }

    /**
     * @return interesMensual representa el interes mensual en formato double
     */ 

    public double getInteresMensual() {
        return interesMensual;
    }
    
    /**
     * @return fechaCierre representa la fecha de cierre
     */ 

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param codigo int que representa un codigo
     * 
     */ 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param banco representa una instancia de la entidad Banco
     */ 
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    /**
     * @param numero representa el numero de cuenta en formato String
     */ 

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @param tipo representa una instancia de la entidad TipoCuenta
     */ 
    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    /**
     * @param fechaApertura representa la fecha de apertura
     */ 
    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * @param saldo representa el saldo en double
     */ 
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @param interesMensual representa el interes mensual en formato double
     */ 
    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    /**
     * @param fechaCierre representa la fecha de cierre
     * 
     */ 
    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    /**
     * @return retorna un string
     */ 
    
    @Override
   public String toString(){
       return String.format("%-8d%-23s%-13s%-15s%-20s%-20.2f%-20.2f%-20s",
                this.getCodigo(),this.getBanco().getNombre(), this.getNumero(), this.getTipo(),this.getFechaApertura(), this.getSaldo(),this.getInteresMensual(),this.getFechaCierre());
   }
}
