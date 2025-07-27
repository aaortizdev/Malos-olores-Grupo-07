/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopoo;
import java.util.Scanner;
import controlador.*;
import vista.*;
/**
 *
 * @author Jair Palaguachi,Julio Llerena,Josue Esparza,Jairo Rodriguez
 * Clase main donde se desarrolla el programa principal con sus opciones
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args metodo main del proyecto
     */
    public static void main(String[] args) {
        
        ControladorFinanzas controlador = new ControladorFinanzas();
        VistaUsuario vista = new VistaUsuario(controlador);
        
                
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    vista.administrarCategorias();
                    break;
                case 2:
                    vista.administrarIngresos();
                    break;
                case 3:
                    vista.administrarGastos();
                    break;
                case 4:
                    vista.administrarCuentasPorCobrar();
                    break;
                case 5:
                    vista.administrarCuentasPorPagar();
                    break;
                case 6:
                    vista.administrarCuentasBancarias();
                    break;
                case 7:
                    vista.administrarInversiones();
                    break;
                case 8:
                    vista.administrarPersonasYBancos();
                    break;
                case 9:
                    vista.generarReportes();
                    break;
                case 10:
                    vista.proyeccionGastos();
                    break;
                case 11:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    

    
}


    

