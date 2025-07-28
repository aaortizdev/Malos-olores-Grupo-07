public class Impuesto {
    public double calcularImpuesto(Empleado emp) {
        return emp.calcularSalarioBase() * 0.10;
    }
}