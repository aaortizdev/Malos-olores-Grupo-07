public class Pago {

    public void procesarPago(String nombreCliente, double monto, String metodoPago, String fechaPago) {
        System.out.println("Procesando pago para: " + nombreCliente);
        System.out.println("Monto: $" + monto);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Fecha de pago: " + fechaPago);

        if (monto <= 0) {
            System.out.println("Error: monto inválido.");
            return;
        }

        if (!metodoPago.equalsIgnoreCase("tarjeta") && !metodoPago.equalsIgnoreCase("efectivo")) {
            System.out.println("Error: método de pago no aceptado.");
            return;
        }
        
        System.out.println("Pago procesado correctamente.");
    }
}