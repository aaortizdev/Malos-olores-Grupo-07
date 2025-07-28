public class Freelance extends Empleado {
    @Override
    public void asistirALaOficina() {
        // El freelancer no tiene por qué ir a la oficina.
        // Método heredado que no tiene sentido aquí.
    }

    @Override
    public void calcularSalario() {
        System.out.println("El freelancer cobra por proyecto.");
    }
}