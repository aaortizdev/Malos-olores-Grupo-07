public class Nomina {
    public double calcularPago(Empleado e) {
        return e.salarioBase + (e.horasExtras * 10);
    }
}