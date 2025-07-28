public class Reporte {
    public void generarResumen(Empleado emp) {
        double salario = emp.calcularSalarioBase();
        System.out.println("Salario base: " + salario);
    }
}