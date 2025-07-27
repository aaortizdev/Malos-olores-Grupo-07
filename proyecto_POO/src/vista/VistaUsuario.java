/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import modelo.*;
import controlador.*;
import java.util.ArrayList;
import java.util.Date;
import modelo.*;




/**
 *
 * @author Jair Palaguachi
 * Clase Vista Usuario junto con sus métodos que se muestran por pantalla al usuario dependiendo de las opciones
 */
public class VistaUsuario {
    
    public static Scanner scanner = new Scanner(System.in);
    ControladorFinanzas controlador;

    /**
     * @param controlador instancia de la Clase ControladorFinanzas 
     */
    public VistaUsuario(ControladorFinanzas controlador) {
        this.controlador = controlador;
    }
    
    
    
    // Métodos para mostrar el Menú Principal
    public  void mostrarMenuPrincipal() {
        System.out.println("Menú Principal:");
        System.out.println("1. Administrar categorías");
        System.out.println("2. Administrar ingresos");
        System.out.println("3. Administrar gastos");
        System.out.println("4. Administrar cuentas por cobrar");
        System.out.println("5. Administrar cuentas por pagar");
        System.out.println("6. Administrar cuentas bancarias");
        System.out.println("7. Administrar inversiones");
        System.out.println("8. Administrar personas y bancos");
        System.out.println("9. Reportes");
        System.out.println("10. Proyección de gastos");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Métodos para administrar Categorias
    public void administrarCategorias() { 
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Categorías:");
            mostrarCategorias();
            System.out.println("1. Agregar Categoría");
            System.out.println("2. Eliminar Categoría");
            System.out.println("3. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarCategoria();
                    break;
                case 2:
                    eliminarCategoria();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarCategorias() { 
        
        List<Categoria> categorias = controlador.getCategorias();
        System.out.println("Categorías de Ingresos:");
        for (Categoria categoria : categorias) {
            if (categoria.getTipo().equals(TipoCategoria.INGRESO)) {
                System.out.println(categoria.getNombre());
            }
        }

        System.out.println("Categorías de Gastos:");
        for (Categoria categoria : categorias) {
            if (categoria.getTipo().equals(TipoCategoria.GASTO)) {
                System.out.println(categoria.getNombre());
            }
        }
    }

    public void agregarCategoria() { 
        System.out.print("Tipo de Categoría (Ingresos/Gastos): ");
        String tipo = scanner.nextLine();
        System.out.print("Nombre de categoría: ");
        String nombre = scanner.nextLine();
        
        if (tipo.equalsIgnoreCase("Ingresos")){
            
            controlador.agregarCategoria(nombre, TipoCategoria.INGRESO);
            System.out.println("Categoría de Ingreso agregada correctamente.");
           
            
        } else if (tipo.equalsIgnoreCase("Gastos")){
            controlador.agregarCategoria(nombre, TipoCategoria.GASTO);
            System.out.println("Categoría de Gasto agregada correctamente.");
            
        }
        
    }

    public void eliminarCategoria() { 
        System.out.print("Tipo de Categoría (Ingresos/Gastos): ");
        String tipo = scanner.nextLine();
        System.out.print("Nombre de categoría a eliminar: ");
        String nombre = scanner.nextLine();
        System.out.println("¿Está seguro de que desea eliminar la categoría de Ingreso '" + nombre + "'? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
            for (Categoria categoria : controlador.getCategorias()){
                if (tipo.equalsIgnoreCase("Ingresos") && categoria.getNombre().equalsIgnoreCase(nombre)){
                    controlador.eliminarCategoria(nombre, TipoCategoria.INGRESO);
                    System.out.println("Categoría de Ingreso eliminada.");
                    return;
                    
                } else if (tipo.equalsIgnoreCase("Gastos") && categoria.getNombre().equalsIgnoreCase(nombre)){
                    controlador.eliminarCategoria(nombre, TipoCategoria.GASTO);
                    System.out.println("Categoría de Gasto eliminada.");
                    return;
                }      
              }
               System.out.println("La categoría no existe.");
          
        } else{
        System.out.println("Eliminación cancelada.");
    }
        System.out.println("Categoria eliminada correctamente.");
    }
    
    
    
    

    // Métodos para administrar ingresos
    public void administrarIngresos() {
        
        mostrarIngresos();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Ingresos:");
            System.out.println("1. Registrar Ingreso");
            System.out.println("2. Eliminar ingreso");
            System.out.println("3. Finalizar ingreso");
            System.out.println("4. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarIngreso();
                    break;
                case 2:
                    eliminarIngreso();
                    break;
                case 3:
                    finalizarIngreso();
                    break;
                case 4:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarIngresos() {
        List<Transaccion> ingresos = controlador.getIngresos();
        System.out.printf("%-10s%-16s%-12s%-15s%-18s%-12s%-12s\n", "Código", "Fecha inicio", "Categoría", "Valor Neto", "Descripción", "Fecha fin", "Repetición");
        for (Transaccion ingreso : ingresos) {
            System.out.println(ingreso);
        }
    }

    public void registrarIngreso() {
        
        
        System.out.print("Categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = buscarCategoria(nombreCategoria, TipoCategoria.INGRESO);
        if(categoria == null){
            System.out.println("Categoria no existente");
            return;
        }
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        System.out.print("Repetición (sin repetición/diaria/semanal/mensual): ");
        String repeticion = scanner.nextLine();
        System.out.print("Fecha fin (YYYY-MM-DD) (opcional/Enter): ");
        String fechaFinStr = scanner.nextLine();
        LocalDate fechaFin = fechaFinStr.isEmpty() ? null : LocalDate.parse(fechaFinStr);
        
        if (repeticion.equalsIgnoreCase("sin repetición")){
            controlador.registrarIngreso(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.SINREPETICION);
            
        } else if (repeticion.equalsIgnoreCase("diaria")){
            controlador.registrarIngreso(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.DIA);
          
        }else if (repeticion.equalsIgnoreCase("semanal")){
            controlador.registrarIngreso(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.SEMANA);
          
        }else if (repeticion.equalsIgnoreCase("mensual")){
            controlador.registrarIngreso(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.MES);
          
        }
        
        System.out.println("Ingreso agregado correctamente.");

        
    }

    public void eliminarIngreso() {
        System.out.print("Código del ingreso a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("ADVERTENCIA: al eliminar no se tomará en cuenta para los reportes de saldos");
        System.out.println("¿Está seguro de que desea eliminar el Ingreso ? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
           controlador.eliminarIngreso(codigo);
        } else {
        System.out.println("Eliminación cancelada.");
    }
       System.out.println("Ingreso eliminado correctamente."); 
    }

    public void finalizarIngreso() { 
        System.out.print("Código del ingreso a finalizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
        controlador.finalizarIngreso(codigo, fechaFin);
        System.out.println("Ingreso finalizado correctamente.");
    }

    // Métodos para administrar gastos
    public void administrarGastos() { 
        mostrarGastos();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Gastos:");
            
            System.out.println("1. Registrar Gasto");
            System.out.println("2. Eliminar Gasto");
            System.out.println("3. Finalizar Gasto");
            System.out.println("4. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarGasto();
                    break;
                case 2:
                    eliminarGasto();
                    break;
                case 3:
                    finalizarGasto();
                    break;
                case 4:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarGastos() {
        List<Transaccion> gastos = controlador.getGastos();
        System.out.printf("%-10s%-16s%-15s%-14s%-18s%-12s%-12s\n", "Código", "Fecha inicio", "Categoría", "Valor", "Descripción", "Fecha fin", "Repetición");
        for (Transaccion gasto : gastos) {
            System.out.println(gasto);
        }
    }

    public void registrarGasto() {
        
        System.out.print("Categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = buscarCategoria(nombreCategoria, TipoCategoria.GASTO);
        if(categoria == null){
            System.out.println("Categoria no existente");
            return;
        }
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        System.out.print("Repetición (sin repetición/diaria/semanal/mensual): ");
        String repeticion = scanner.nextLine();
        System.out.print("Fecha fin (YYYY-MM-DD) (opcional/Enter): ");
        String fechaFinStr = scanner.nextLine();
        LocalDate fechaFin = fechaFinStr.isEmpty() ? null : LocalDate.parse(fechaFinStr);
        
        if (repeticion.equalsIgnoreCase("sin repetición")){
            controlador.registrarGasto(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.SINREPETICION);
            
        } else if (repeticion.equalsIgnoreCase("diaria")){
            controlador.registrarGasto(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.DIA);
          
        }else if (repeticion.equalsIgnoreCase("semanal")){
            controlador.registrarGasto(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.SEMANA);
          
        }else if (repeticion.equalsIgnoreCase("mensual")){
            controlador.registrarGasto(fechaInicio, categoria, valor, descripcion, fechaFin, Repeticion.MES);
          
        }
        System.out.println("Gasto agregado correctamente.");
 
    }

    public void eliminarGasto() {
        System.out.print("Código del gasto a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("ADVERTENCIA: al eliminar no se tomará en cuenta para los reportes de saldos");
        System.out.println("¿Está seguro de que desea eliminar el Gasto ? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
           controlador.eliminarGasto(codigo);
        } else {
        System.out.println("Eliminación cancelada.");
    }
       System.out.println("Gasto eliminado correctamente.");  
    }

    public void finalizarGasto() {
        System.out.print("Código del gasto a finalizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
        controlador.finalizarGasto(codigo, fechaFin);
        System.out.println("Gasto finalizado correctamente."); 
    }

    // Métodos para administrar cuentas por cobrar
    public void administrarCuentasPorCobrar() {
        mostrarCuentasPorCobrar();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Cuentas por Cobrar:");
            
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarPrestamo();
                    break;
                case 2:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarCuentasPorCobrar() {
        List<CuentasPorCobrar> cuentasPorCobrar = controlador.getCuentasPorCobrar();
         System.out.printf("%-8s%-15s%-15s%-20s%-18s%-20s%-20s%-20s%-20s\n", "Código", "Deudor", "Valor", "Descripción", "Fecha préstamo","Cuotas préstamo","FechaInicioPago","FechaFinPago","Cedula");
        for (CuentasPorCobrar cuenta : cuentasPorCobrar) {
            System.out.println(cuenta);
        }
    }

    public void registrarPrestamo() {
        System.out.print("CI del deudor: ");
        String ci = scanner.nextLine();
        Persona deudor = buscarPersona(ci);
        if (deudor == null){
            registrarPersonaBanco("P");
            System.out.println("Persona registrada ");
            
        } else{
            System.out.println(deudor.getNombre());
        
        System.out.print("Valor del préstamo: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha del préstamo (YYYY-MM-DD): ");
        LocalDate fechaPrestamo = LocalDate.parse(scanner.nextLine());
        System.out.print("Cuota mensual: ");
        double cuota = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha inicio de pago (YYYY-MM-DD): ");
        LocalDate fechaInicioPago = LocalDate.parse(scanner.nextLine());
        System.out.print("Fecha fin de pago (YYYY-MM-DD): ");
        LocalDate fechaFinPago = LocalDate.parse(scanner.nextLine());

        controlador.registrarPrestamo(deudor, valor, descripcion, fechaPrestamo, cuota, fechaInicioPago, fechaFinPago,ci);
        }
        System.out.println("Préstamo agregado correctamente.");
    }

    // Métodos para administrar cuentas por pagar
    public void administrarCuentasPorPagar() {
        mostrarCuentasPorPagar();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Cuentas por Pagar:");
            
            System.out.println("1. Registrar deuda");
            System.out.println("2. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarDeuda();
                    break;
                case 2:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarCuentasPorPagar() {
        List<CuentasPorPagar> cuentasPorPagar = controlador.getCuentasPorPagar();
        System.out.printf("%-8s%-15s%-15s%-20s%-18s%-20s%-20s%-20s%-20s%-12s\n", "Código", "Deudor", "Valor", "Descripción", "Fecha préstamo","Cuotas préstamo","FechaInicioPago","FechaFinPago","Cedula/Ruc","Interés");
        for (CuentasPorPagar cuenta : cuentasPorPagar) {
            System.out.println(cuenta);
        }
    }

    public void registrarDeuda() {
        System.out.print("La deuda es de una Persona o un Banco? (P/B): ");
        String tipo = scanner.nextLine();
        System.out.print("CI/RUC del acreedor: ");
        String ci = scanner.nextLine();
        Entidad acreedor = buscarPersonaBanco(ci);
        if (acreedor == null){
            if (tipo.equalsIgnoreCase("P")){
                registrarPersonaBanco("P");
                System.out.println("Persona registrada ");
            } else{
                registrarPersonaBanco("B");
                System.out.println("Banco registrado ");
            }
            
        } else{
            System.out.println(acreedor.getNombre());
        
        System.out.print("Valor de la deuda: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha del préstamo (YYYY-MM-DD): ");
        LocalDate fechaPrestamo = LocalDate.parse(scanner.nextLine());
        System.out.print("Cuota mensual: ");
        double cuota = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Interés mensual: ");
        double interes = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha inicio de pago (YYYY-MM-DD): ");
        LocalDate fechaInicioPago = LocalDate.parse(scanner.nextLine());
        System.out.print("Fecha fin de pago (YYYY-MM-DD): ");
        LocalDate fechaFinPago = LocalDate.parse(scanner.nextLine());

        controlador.registrarDeuda(acreedor, valor, descripcion, fechaPrestamo, cuota , fechaInicioPago, fechaFinPago,ci,interes);
    }
        System.out.println("Deuda agregada correctamente.");
        }

    // Métodos para administrar cuentas bancarias
    public void administrarCuentasBancarias() {
        mostrarCuentasBancarias();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Cuentas Bancarias:");
            
            System.out.println("1. Registrar cuenta bancaria");
            System.out.println("2. Eliminar cuenta bancaria");
            System.out.println("3. Cerrar cuenta bancaria");
            System.out.println("4. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarCuentaBancaria();
                    break;
                case 2:
                    eliminarCuentaBancaria();
                    break;
                case 3:
                    cerrarCuentaBancaria();
                    break;
                case 4:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }


    public void mostrarCuentasBancarias() {
        List<CuentaBancaria> cuentasBancarias = controlador.getCuentasBancarias();
        System.out.printf("%-8s%-23s%-13s%-15s%-20s%-20s%-20s%-20s\n", "Código", "Entidad Bancaria", "Numero", "Tipo", "Fecha Apertura","Saldo","Interés","Fecha Cierre");
        for (CuentaBancaria cuenta : cuentasBancarias) {
            System.out.println(cuenta);
        }
    }

    public void registrarCuentaBancaria() {
        System.out.print("CI del banco: ");
        String ci = scanner.nextLine();
        Banco banco = buscarBanco(ci);
        if(banco == null){
            System.out.println("Banco no existente");
            return;
        }
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        System.out.print("Tipo de cuenta (AHORRO/CORRIENTE): ");
        String tipo = scanner.nextLine();
        System.out.print("Fecha de apertura (YYYY-MM-DD): ");
        LocalDate fechaApertura = LocalDate.parse(scanner.nextLine());
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Interés mensual: ");
        double interesMensual = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha fin (YYYY-MM-DD) (opcional/Enter): ");
        String fechaFinStr = scanner.nextLine();
        LocalDate fechaCierre = fechaFinStr.isEmpty() ? null : LocalDate.parse(fechaFinStr);
        
        if (tipo.equalsIgnoreCase("AHORRO")){
            controlador.registrarCuentaBancaria(banco, numero, TipoCuenta.AHORRO, fechaApertura, saldo, interesMensual,fechaCierre );
            
        } else if (tipo.equalsIgnoreCase("CORRIENTE")){
            controlador.registrarCuentaBancaria(banco, numero, TipoCuenta.CORRIENTE, fechaApertura, saldo, interesMensual,fechaCierre );
        }
        System.out.println("Cuenta Bancaria agregada correctamente.");
    }

    public void eliminarCuentaBancaria() {
        System.out.print("Código de la cuenta bancaria a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("ADVERTENCIA: al eliminar no se tomará en cuenta para los reportes de saldos");
        System.out.println("¿Está seguro de que desea eliminar el Gasto ? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
           controlador.eliminarCuentaBancaria(codigo);
        } else {
        System.out.println("Eliminación cancelada.");
        
    }
        System.out.println("Cuenta Bancaria eliminada correctamente."); 
    }
    

    public void cerrarCuentaBancaria() {
        System.out.print("Código de la cuenta bancaria a cerrar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha de cierre (YYYY-MM-DD): ");
        LocalDate fechaCierre = LocalDate.parse(scanner.nextLine());
        controlador.cerrarCuentaBancaria(codigo, fechaCierre);
        System.out.println("Cuenta Bancaria cerrada correctamente."); 
    }

    // Métodos para administrar inversiones
    public void administrarInversiones() {
        mostrarInversiones();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Inversiones:");
            
            System.out.println("1. Registrar inversión");
            System.out.println("2. Eliminar inversión");
            System.out.println("3. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarInversion();
                    break;
                case 2:
                    eliminarInversion();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarInversiones() {
        List<Inversion> inversiones = controlador.getInversiones();
        System.out.printf("%-10s%-23s%-20s%-20s%-20s%-20s\n", "Código", "Entidad Bancaria", "Fecha Apertura","Cantidad","Interés Mensual","Fecha Finalizacíon");
        for (Inversion inversion : inversiones) {
            System.out.println(inversion);
        }
    }

    public void registrarInversion() {
        System.out.print("CI del banco: ");
        String ci = scanner.nextLine();
        Banco banco = buscarBanco(ci);
        if(banco == null){
            System.out.println("Banco no existente");
            return;
        }
        System.out.print("Fecha de apertura (YYYY-MM-DD): ");
        LocalDate fechaApertura = LocalDate.parse(scanner.nextLine());
        System.out.print("Cantidad invertida: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Interés mensual: ");
        double interesMensual = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Fecha de finalización (YYYY-MM-DD): ");
        LocalDate fechaFinalizacion = LocalDate.parse(scanner.nextLine());

        controlador.registrarInversion(banco, fechaApertura, cantidad, interesMensual, fechaFinalizacion);
        System.out.println("Inversión agregada correctamente.");
    }

    public void eliminarInversion() {
        System.out.print("Código de la inversión a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("ADVERTENCIA: al eliminar no se tomará en cuenta para los reportes de saldos");
        System.out.println("¿Está seguro de que desea eliminar el Gasto ? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
           controlador.eliminarInversion(codigo);
        } else {
        System.out.println("Eliminación cancelada.");
        
    }
        System.out.println("Inversión eliminada correctamente."); 
    }

    // Métodos para administrar personas y bancos
    public void administrarPersonasYBancos() {
        mostrarPersonas();
        mostrarBancos();
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Administrar Personas y Bancos:");
            
            System.out.println("1. Registrar Persona/Banco");
            System.out.println("2. Eliminar Persona/Banco");
            System.out.println("3. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Desea registrar una Persona o un Banco? (P/B)");
                    String tipo = scanner.nextLine();
                    registrarPersonaBanco(tipo);
                    break;
                case 2:
                    eliminarPersonaBanco();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarPersonas() {
        List<Persona> personas = controlador.getPersonas();
        System.out.println("Personas Registradas:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public void mostrarBancos() {
        List<Banco> bancos = controlador.getBancos();
        System.out.println("Bancos Registrados:");
        for (Banco banco : bancos) {
            System.out.println(banco);
        }
    }
    
    /**
     * @param tipo String que sirve para identificar si se desa registrar una persona o banco 
     */
    // Métodos para registrar/eliminar Personas o Bancos
    public void registrarPersonaBanco(String tipo) {
        if (tipo.equalsIgnoreCase("P")){
            System.out.print("CI: ");
            String ci = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();

        controlador.registrarPersona(ci, nombre, telefono, direccion);
        System.out.println("Persona registrada correctamente.");

        } else if(tipo.equalsIgnoreCase("B")){
            System.out.print("RUC: ");
            String ci = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("NombreOficialCredito: ");
            String nombreOficialCredito = scanner.nextLine();
            System.out.print("TeléfonoOficialCredito: ");
            String telefonoOficialCredito = scanner.nextLine();

        controlador.registrarBanco(ci, nombre,telefono,direccion, nombreOficialCredito,telefonoOficialCredito);
        System.out.println("Banco registrado correctamente.");
        }
        
       
    }
    
    public void eliminarPersonaBanco() {
        System.out.print("Ingrese el identificador (cédula o ruc) de la persona o banco a eliminar: ");
        String codigo = scanner.nextLine();
        Entidad entidad=buscarPersonaBanco(codigo);
        System.out.println(entidad);
        //scanner.nextLine(); // Consumir el salto de línea
        System.out.println("ADVERTENCIA: se eliminaran todos los registros asociados (cuentas por cobrar, deudas o inversiones)");
        System.out.println("¿Está seguro de que desea eliminar el Gasto ? (si/no)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("si")){
           controlador.eliminarPersonaBanco(codigo);
        } else {
        System.out.println("Eliminación cancelada.");
    }
    System.out.println("Persona/Banco eliminado correctamente."); 
    }

    
    // Métodos para generar reportes
    public void generarReportes() {
        boolean regresar = false;
        while (!regresar) {
            System.out.println("Generar Reportes:");
            System.out.println("1. Reporte de ingresos");
            System.out.println("2. Reporte de gastos");
            System.out.println("3. Regresar Menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    generarReporteIngresos();
                    break;
                case 2:
                    generarReporteGastos();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
    // Métodos para generar reportes Ingresos
    public void generarReporteIngresos(){
        boolean regresar = false;
        while (!regresar) {
            
            System.out.println("Seleccionar Periodo:");
            System.out.println("1. Mes actual");
            System.out.println("2. Año");
            System.out.println("3. Regresar Menú Principal");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    generarReporteIngresosMes();
                    break;
                case 2:
                    generarReporteIngresosAño();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void generarReporteIngresosMes() {
        System.out.println("Reporte de Ingresos:");
        System.out.println("Ingrese el mes que desee (numero): ");
        int mes = scanner.nextInt();

        double valorT = 0;

        System.out.println("Categoria                   Valor");
        

        for(Transaccion i : controlador.getIngresos()){

          if(i.getFechaInicio().getMonthValue()==mes){

            System.out.println(i.getCategoria().getNombre()+ "                     " +i.getValor());

            valorT += i.getValor();
            
          }

        }
        System.out.println("Total                       " + valorT);
        
    }
    
    public void generarReporteIngresosAño() {
        System.out.println("Reporte de Ingresos:");
        System.out.println("Ingrese el año que desee: ");
        int anio = scanner.nextInt();
        
        double valorT2 = 0;

        System.out.println("Ingrese el mes actual: ");
        int mes = scanner.nextInt();

          for(Transaccion i : controlador.getIngresos()){

          if(i.getFechaInicio().getYear() == anio && i.getFechaInicio().getMonthValue()<= mes){
              System.out.println(i.getFechaInicio().getMonth());
              System.out.println(" Categoria             Valor");
            
              System.out.println(i.getCategoria().getNombre()+ "              " +i.getValor());
              valorT2 += i.getValor();
              
            }

          }
          System.out.println("Total                       " + valorT2);
        
    }
    
    

    // Métodos para generar reportes Gastos
    public void generarReporteGastos(){
        boolean regresar = false;
        while (!regresar) {
            
            System.out.println("Seleccionar Periodo:");
            System.out.println("1. Mes actual");
            System.out.println("2. Año");
            System.out.println("3. Regresar Menú Principal");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    generarReporteGastosMes();
                    break;
                case 2:
                    generarReporteGastosAño();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    public void generarReporteGastosMes() {
        System.out.println("Reporte de Gastos:");
        System.out.println("Ingrese el mes que desee (numero): ");
        int mes = scanner.nextInt();

        double valorT = 0;

        System.out.println("Categoria                   Valor");
        

        for(Transaccion i : controlador.getGastos()){

          if(i.getFechaInicio().getMonthValue()==mes){

            System.out.println(i.getCategoria().getNombre()+ "                     " +i.getValor());

            valorT += i.getValor();
            
          }

        }
        System.out.println("Total                       " + valorT);
    }
    
    public void generarReporteGastosAño(){
        System.out.println("Reporte de Gastos:");
        System.out.println("Ingrese el año que desee: ");
        int anio = scanner.nextInt();
        
        double valorT2 = 0;

        System.out.println("Ingrese el mes actual: ");
        int mes = scanner.nextInt();

          for(Transaccion i : controlador.getGastos()){

          if(i.getFechaInicio().getYear() == anio && i.getFechaInicio().getMonthValue()<= mes){
              System.out.println(i.getFechaInicio().getMonth());
              System.out.println(" Categoria             Valor");
            
              System.out.println(i.getCategoria().getNombre()+ "              " +i.getValor());
              valorT2 += i.getValor();
              
            }

          }
          System.out.println("Total                       " + valorT2);
    }
    
    
    
    // Método para proyección de gastos
    public void proyeccionGastos() {
        System.out.println("Gastos en los últimos tres meses:");
        Date fechaActual = new Date();
        double suma=0;
        int cantidadGastos=0;
       
        for(Transaccion i : controlador.getGastos()){
         if(i.getFechaInicio().getMonthValue()> fechaActual.getMonth()-3){
             System.out.println(i.getFechaInicio().getMonth());
              System.out.println(" Categoria             Valor");
            
              System.out.println(i.getCategoria().getNombre()+ "              " +i.getValor());
              
              suma+=i.getValor();
              cantidadGastos+=1;
              controlador.registrarProyeccion(i.getCategoria().getNombre(), i.getValor());
            }
         }
         ArrayList<Proyeccion> proyecciones = controlador.getProyecciones();
         
         ArrayList<String> categoriasProyeccion=new ArrayList<>();
         ArrayList<Double> valoresProyeccion=new ArrayList<>();
         
         for (Proyeccion proyeccion:proyecciones){
              if (!categoriasProyeccion.contains(proyeccion.getCategoria())){
               categoriasProyeccion.add(proyeccion.getCategoria());
               valoresProyeccion.add(proyeccion.getValor());
               
              } else {
               int posicion= categoriasProyeccion.indexOf(proyeccion.getCategoria());
               double elemento= valoresProyeccion.get(posicion);
               valoresProyeccion.set(posicion, elemento+=proyeccion.getValor());
             }
        }
            
        System.out.println("Proyección de gastos para el próximo mes:");
         
           for(int i=0;i<categoriasProyeccion.size();i++){
               System.out.println(categoriasProyeccion.get(i)+ "              " + valoresProyeccion.get(i)/3); // asumiendo que el usuario tuvo el mismo gasto en los tres meses
           }
              System.out.println("Valor Total");
              System.out.println(suma/cantidadGastos);
        
    }

 /**
     * @param nombre String que identifica el nombre de una categoria
     * @param tipo String que identifica el tipo de una categoria
     * @return el método retorna una instancia de la clase Categoria o null
     * 
     */            
// Método para buscar instancias de las clases Categoria, Persona, Banco
    public Categoria buscarCategoria(String nombre, TipoCategoria tipo) {
        List<Categoria> categorias = controlador.getCategorias();
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equals(nombre) && categoria.getTipo().equals(tipo)) {
                return categoria;
            }
        }
        return null;
    }
    
/**
     * @param ci String que identifica el ruc/cedula de una persona/banco
     * @return el método retorna una instancia de la clase Persona, una instancia de la clase Banco o null
     * 
     */ 
    public Entidad buscarPersonaBanco(String ci) {
        List<Persona> personas = controlador.getPersonas();
        for (Persona persona : personas) {
            if (persona.getRucId().equals(ci)) {
                return persona;
            }
        }
        List<Banco> bancos = controlador.getBancos();
        for (Banco banco : bancos) {
            if (banco.getRucId().equals(ci)) {
                return banco;
            }
        }
        return null;
    }
    
    /**
     * @param ci String que identifica la cedula de una persona
     * @return el método retorna una instancia de la clase Persona o null
     * 
     */ 
    public Persona buscarPersona(String ci) {
        List<Persona> personas = controlador.getPersonas();
        for (Persona persona : personas) {
            if (persona.getRucId().equals(ci)) {
                return persona;
            }
        }
        return null;
    }
    
    /**
     * @param ci String que identifica el ruc de un banco
     * @return  el método retorna una instancia de la clase Banco o null
     * 
     */ 
    public Banco buscarBanco(String ci) {
        List<Banco> bancos = controlador.getBancos();
        for (Banco banco : bancos) {
            if (banco.getRucId().equals(ci)) {
                return banco;
            }
        }
        return null;
    }
    
}
