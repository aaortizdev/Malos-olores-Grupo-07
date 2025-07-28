public class GestorEmpleado {
    private Empleado empleado;

    public GestorEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNombreEmpleado() {
        return empleado.getNombre();
    }

    public String getCargoEmpleado() {
        return empleado.getCargo();
    }
}