// Clase Pedido con mal olor
public class Pedido {
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public String obtenerPaisDeEnvio() {
        return cliente.getDireccion().getPais().getNombre();
    }
}