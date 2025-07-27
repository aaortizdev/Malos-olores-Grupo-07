/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;
/**
 *
 * @author Jair Palaguachi
 * @author Julio Llerena
 * @author Josue Esparza
 * @author Jairo Rodriguez
 * Clase que almacena todos los controladores necesarios para el funcionamiento del proyecto
 */
public class ControladorFinanzas {
    private ArrayList<Categoria> categorias;
    private ArrayList<Transaccion> ingresos;
    private ArrayList<Transaccion> gastos;
    private ArrayList<CuentasPorCobrar> cuentasPorCobrar;
    private ArrayList<CuentasPorPagar> cuentasPorPagar;
    private ArrayList<CuentaBancaria> cuentasBancarias;
    private ArrayList<Inversion> inversiones;
    private ArrayList<Persona> personas;
    private ArrayList<Banco> bancos;
    private ArrayList<Proyeccion> proyecciones;
    

    public ControladorFinanzas() {
        categorias = new ArrayList<>();
        ingresos = new ArrayList<>();
        gastos = new ArrayList<>();
        cuentasPorCobrar = new ArrayList<>();
        cuentasPorPagar = new ArrayList<>();
        cuentasBancarias = new ArrayList<>();
        inversiones = new ArrayList<>();
        personas = new ArrayList<>();
        bancos = new ArrayList<>();
        proyecciones = new ArrayList<>();
        

        inicializarDatos();
    }
    
    /*
    Metodo que inicializa el programa con los siguientes datos:
        2 categoría de Ingresos y 2 categorías de Gastos
        2 ingresos
        2 gastos
        1 cuenta por cobrar
        1 cuenta por pagar
        1 cuenta bancaria
        1 inversión
        1 persona natural
        1 banco
  
    */
    private void inicializarDatos() {
        // Inicializar categorías
        categorias.add(new Categoria("Salario", TipoCategoria.INGRESO));
        categorias.add(new Categoria("Alquiler", TipoCategoria.INGRESO));
        categorias.add(new Categoria("Comida", TipoCategoria.GASTO));
        categorias.add(new Categoria("Transporte", TipoCategoria.GASTO));

        // Inicializar ingresos
        ingresos.add(new Ingreso(LocalDate.of(2024, 1, 1), categorias.get(0), 1000, "Sueldo Enero", null, Repeticion.MES));
        ingresos.add(new Ingreso(LocalDate.of(2024, 2, 1), categorias.get(0), 2000, "Sueldo Febrero", null, Repeticion.MES));

        // Inicializar gastos
        gastos.add(new Gasto(LocalDate.of(2024, 1, 1), categorias.get(2), 200, "Comida Enero", null, Repeticion.MES));
        gastos.add(new Gasto(LocalDate.of(2024, 2, 1), categorias.get(3), 100, "Transporte Febrero", null, Repeticion.MES));

        // Inicializar cuentas por cobrar
        personas.add(new Persona("0102030405", "Pedro López", "0998765432", "pedro@gmail.com"));
        cuentasPorCobrar.add(new CuentasPorCobrar(personas.get(0), 500, "Préstamo a Pedro", LocalDate.of(2024, 2, 2), 50, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 6, 1),"0102030405"));

        // Inicializar cuentas por pagar
        personas.add(new Persona("0102030406", "Carlos Murillo", "0998765433", "carlos@gmail.com"));
        cuentasPorPagar.add(new CuentasPorPagar(personas.get(1), 15000, "Préstamo para auto", LocalDate.of(2024, 2, 2), 600, LocalDate.of(2024, 3, 1), LocalDate.of(2025, 2, 1),"0102030406", 5.0));

        // Inicializar cuentas bancarias
        bancos.add(new Banco("1790018230001", "Banco del Pacifico","0955567890" ,"contacto@bancopacifico.com", "Rosa C", "0991122334"));
        cuentasBancarias.add(new CuentaBancaria(bancos.get(0), "1034324", TipoCuenta.AHORRO, LocalDate.of(2024, 1, 1), 600, 0.05,LocalDate.of(2025, 1, 1)));

        // Inicializar inversiones
        inversiones.add(new Inversion(bancos.get(0), LocalDate.of(2024, 2, 1), 1000, 0.02, LocalDate.of(2025, 2, 1)));
    }

    /**
     * @return categorias Arraylist de categorias
     * 
     */ 
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

     /**
     * @return ingresos Arraylist de ingresos
     * 
     */ 
    public ArrayList<Transaccion> getIngresos() {
        return ingresos;
    }

    /**
     * @return gastos Arraylist de gastos
     * 
     */ 
    public ArrayList<Transaccion> getGastos() {
        return gastos;
    }

    /**
     * @return ingresos Arraylist de ingresos
     * 
     */ 
    public ArrayList<CuentasPorCobrar> getCuentasPorCobrar() {
        return cuentasPorCobrar;
    }
    
    /**
     * @return ingresos Arraylist de ingresos
     * 
     */ 

    public ArrayList<CuentasPorPagar> getCuentasPorPagar() {
        return cuentasPorPagar;
    }

    /**
     * @return cuentasBancarias Arraylist de cuentasBancarias
     * 
     */ 
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    /**
     * @return inversiones Arraylist de inversiones
     * 
     */ 
    public ArrayList<Inversion> getInversiones() {
        return inversiones;
    }
    
    /**
     * @return personas Arraylist de personas
     * 
     */ 

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * @return bancos Arraylist de bancos
     * 
     */ 
    public ArrayList<Banco> getBancos() {
        return bancos;
    }
    
    /**
     * @return proyecciones Arraylist de proyecciones
     * 
     */ 
    public ArrayList<Proyeccion> getProyecciones() {
        return proyecciones;
    }

    /**
     * @param nombre String que identifica el nombre de una categoria
     * @param tipo String que identifica el tipo de una categoria
     *
     */  
    // Métodos para administrar categorías
    public void agregarCategoria(String nombre, TipoCategoria tipo) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombre) && categoria.getTipo().equals(tipo)) {
                System.out.println("La categoría ya existe.");
                return;
            }
        }
        categorias.add(new Categoria(nombre, tipo));
    }
    
    /**
     * @param nombre String que identifica el nombre de una categoria
     * @param tipo String que identifica el tipo de una categoria
     *
     */  

    public void eliminarCategoria(String nombre, TipoCategoria tipo) {
        categorias.removeIf(categoria -> categoria.getNombre().equalsIgnoreCase(nombre) && categoria.getTipo().equals(tipo));
    }
    
    /**
     * @param fechaInicio representa la fecha de inicio 
     * @param categoria representa una instancia de la entidad Categoria
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaFin representa la fecha de fin
     * @param repeticion representa una instancia de la entidad Repeticion
     
     */  

    // Métodos para administrar ingresos
    public void registrarIngreso(LocalDate fechaInicio, Categoria categoria, double valor, String descripcion, LocalDate fechaFin,Repeticion repeticion) {
        ingresos.add(new Ingreso(fechaInicio, categoria, valor, descripcion, fechaFin, repeticion));
    }
    
     /**
     * @param codigo representa el codigo de un ingreso en int
     * 
     */ 

    public void eliminarIngreso(int codigo) {
        ingresos.removeIf(ingreso -> ingreso.getCodigo() == codigo);
    }
    
    /**
     * @param codigo representa el codigo de un ingreso en int
     * @param fechaFin representa la fecha de fin del ingreso
     */ 

    public void finalizarIngreso(int codigo, LocalDate fechaFin) {
        for (Transaccion ingreso : ingresos) {
            if (ingreso.getCodigo() == codigo) {
                if (fechaFin.isAfter(ingreso.getFechaInicio())) {
                    ingreso.setFechaFin(fechaFin);
                } else {
                    System.out.println("La fecha de finalización debe ser mayor que la fecha de inicio.");
                }
                return;
            }
        }
    }
    
    /**
     * @param fechaInicio representa la fecha de inicio 
     * @param categoria representa una instancia de la entidad Categoria
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaFin representa la fecha de fin
     * @param repeticion representa una instancia de la entidad Repeticion
     */  

    // Métodos para administrar gastos
    public void registrarGasto(LocalDate fechaInicio, Categoria categoria, double valor, String descripcion, LocalDate fechaFin, Repeticion repeticion) {
        gastos.add(new Gasto(fechaInicio, categoria, valor, descripcion, fechaFin, repeticion));
    }
    
    /**
     * @param codigo representa el codigo de un ingreso en int
     * 
     */

    public void eliminarGasto(int codigo) {
        gastos.removeIf(gasto -> gasto.getCodigo() == codigo);
    }
    
    /**
     * @param codigo representa el codigo de un ingreso en int
     * @param fechaFin representa la fecha de fin del ingreso
     */ 

    public void finalizarGasto(int codigo, LocalDate fechaFin) {
        for (Transaccion gasto : gastos) {
            if (gasto.getCodigo() == codigo) {
                if (fechaFin.isAfter(gasto.getFechaInicio())) {
                    gasto.setFechaFin(fechaFin);
                } else {
                    System.out.println("La fecha de finalización debe ser mayor que la fecha de inicio.");
                }
                return;
            }
        }
    }
    
    /**
     * @param deudor representa una instancia de la entidad Persona
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaPrestamo representa la fecha de prestamo
     * @param cuota representa la cuota en double
     * @param fechaInicioPago representa la fecha de inicio del pago
     * @param fechaFinPago representa la fecha de fin del pago
     * @param cedula representa la cedula en formato String
     * 
     */ 

    // Métodos para administrar cuentas por cobrar
    public void registrarPrestamo(Persona deudor, double valor, String descripcion, LocalDate fechaPrestamo, double cuota, LocalDate fechaInicioPago, LocalDate fechaFinPago,String cedula) {
        cuentasPorCobrar.add(new CuentasPorCobrar(deudor, valor, descripcion, fechaPrestamo, cuota, fechaInicioPago, fechaFinPago,cedula));
    }
    
    /**
     * @param acreedor representa una instancia de la entidad Persona
     * @param valor representa el valor en double
     * @param descripcion representa una instancia de la entidad Categoria
     * @param fechaPrestamo representa la fecha de prestamo
     * @param cuota representa la cuota en double
     * @param fechaInicioPago representa la fecha de inicio del pago
     * @param fechaFinPago representa la fecha de fin del pago
     * @param RucId representa la cedula o ruc en formato String
     * @param interes representa el interes en formato double
     */ 

    // Métodos para administrar cuentas por pagar
    public void registrarDeuda(Entidad acreedor, double valor, String descripcion, LocalDate fechaPrestamo, double cuota, LocalDate fechaInicioPago, LocalDate fechaFinPago,String RucId,double interes) {
        cuentasPorPagar.add(new CuentasPorPagar(acreedor, valor, descripcion, fechaPrestamo, cuota, fechaInicioPago, fechaFinPago,RucId, interes));
    }
    
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

    // Métodos para administrar cuentas bancarias
    public void registrarCuentaBancaria(Banco banco, String numero, TipoCuenta tipo, LocalDate fechaApertura, double saldo, double interesMensual,LocalDate fechaCierre) {
        cuentasBancarias.add(new CuentaBancaria(banco, numero, tipo, fechaApertura, saldo, interesMensual,fechaCierre));
    }
    
    /**
     * @param codigo representael codigo en formato int
     */ 

    public void eliminarCuentaBancaria(int codigo) {
        cuentasBancarias.removeIf(cuenta -> cuenta.getCodigo() == codigo);
    }

    /**
     * @param codigo representael codigo en formato int
     * @param fechaCierre representa la fecha de cierre
     */ 
    public void cerrarCuentaBancaria(int codigo, LocalDate fechaCierre) {
        for (CuentaBancaria cuenta : cuentasBancarias) {
            if (cuenta.getCodigo() == codigo) {
               if (fechaCierre.isAfter(cuenta.getFechaApertura())) {
                    cuenta.setFechaCierre(fechaCierre);
                
                } else {
                    System.out.println("La fecha de cierre debe ser mayor que la fecha de apertura.");
                }
                return;    
        }
    }
    }
    
    /**
     * @param banco representa una instancia de la entidad Banco
     * @param fechaApertura representa la fecha de apertura
     * @param cantidad representa la cantidad de inversion en formato double
     * @param interesMensual representa el interes mensual en formato double
     * @param fechaFinalizacion representa la fecha de finalizacion
     * 
     */ 

    // Métodos para administrar inversiones
    public void registrarInversion(Banco banco, LocalDate fechaApertura, double cantidad, double interesMensual, LocalDate fechaFinalizacion) {
        inversiones.add(new Inversion(banco, fechaApertura, cantidad, interesMensual, fechaFinalizacion));
    }

    /**
     * @param codigo representael codigo en formato int
     */ 
    public void eliminarInversion(int codigo) {
        inversiones.removeIf(inversion -> inversion.getCodigo() == codigo);
    }
    
    /**
     * @param ci representa la cedula en formato String
     * @param nombre representa el nombre  en formato String
     * @param telefono representa el telefono en formato String
     * @param direccion representa la direccion en formato String
     * 
     */ 
    
    public void registrarPersona(String ci, String nombre, String telefono, String direccion){
        personas.add(new Persona(ci,nombre,telefono,direccion));
    }
    
    /**
     * @param ci representa la cedula en formato String
     * @param nombre representa el nombre  en formato String
     * @param telefono representa el telefono en formato String
     * @param direccion representa la direccion en formato String
     * @param nombreOficialCredito representa el nombre de un oficial de credito en formato String
     * @param telefonoOficialCredito representa el telefono de un oficial de credito en formato String
     * 
     */ 
    
    public void registrarBanco(String ci, String nombre, String telefono,String direccion, String nombreOficialCredito,String telefonoOficialCredito){
        bancos.add(new Banco(ci,nombre,telefono,direccion,nombreOficialCredito,telefonoOficialCredito));
    }
    
    /**
     * @param identificador representa la cedula o ruc en formato String
     */ 
    
    public void eliminarPersonaBanco(String identificador) {
        personas.removeIf(persona -> persona.getRucId().equalsIgnoreCase(identificador));
        bancos.removeIf(banco -> banco.getRucId().equalsIgnoreCase(identificador));
    }
    /**
     * @param categoria representa la categoria formato String
     * @param valor representa el valor en formato double
     */ 
    
    
    public void registrarProyeccion( String categoria, double valor) {
        proyecciones.add(new Proyeccion(categoria, valor));
    }
    
    
}
