public class Pedido {
    private Cliente cliente;
    private double monto;

    public Pedido(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public String generarEtiquetaEnvio() {
        return cliente.getNombre() + "\n" +
               cliente.getDireccion().getCalle() + "\n" +
               cliente.getDireccion().getCiudad();
    }
}