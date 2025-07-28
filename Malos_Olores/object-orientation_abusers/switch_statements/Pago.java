public class Pago {
    public void procesarPago(String metodo, double cantidad) {
        switch (metodo) {
            case "EFECTIVO":
                System.out.println("Pagando " + cantidad + " en efectivo.");
                break;
            case "TARJETA":
                System.out.println("Pagando " + cantidad + " con tarjeta.");
                break;
            case "TRANSFERENCIA":
                System.out.println("Pagando " + cantidad + " por transferencia.");
                break;
            default:
                System.out.println("Método de pago no reconocido.");
        }
    }
}