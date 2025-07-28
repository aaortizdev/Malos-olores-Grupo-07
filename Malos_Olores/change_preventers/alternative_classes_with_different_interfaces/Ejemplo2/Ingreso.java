public class Ingreso {
    private double monto;
    private String categoria;

    public Ingreso(double monto, String categoria) {
        this.monto = monto;
        this.categoria = categoria;
    }

    public double obtenerMonto() {
        return monto;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public void procesarIngreso() {
        System.out.println("Procesando ingreso de: " + monto);
    }
}