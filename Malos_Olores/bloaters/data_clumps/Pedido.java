public class Pedido {
    public void crearPedido(String nombreCliente, String direccion, String telefono) {
        System.out.println("Creando pedido para " + nombreCliente);
    }

    public void enviarFactura(String nombreCliente, String direccion, String telefono) {
        System.out.println("Enviando factura a " + direccion);
    }

    public void registrarCliente(String nombreCliente, String direccion, String telefono) {
        System.out.println("Registrando cliente " + nombreCliente);
    }
}
