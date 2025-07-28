public class Empleado {
    protected String nombre;
    protected double salario;

    public void calcularSalario() {
        System.out.println("Salario base: " + salario);
    }

    public void asistirALaOficina() {
        System.out.println(nombre + " va a la oficina.");
    }
}