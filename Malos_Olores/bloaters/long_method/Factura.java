public class Factura {
    public void generarFactura(Cliente cliente, List<Item> items) {
        double total = 0;

        // Calcular subtotal
        for (Item item : items) {
            double precio = item.getPrecio();
            int cantidad = item.getCantidad();
            total += precio * cantidad;
        }

        // Aplicar impuestos
        double impuesto = total * 0.12;
        total += impuesto;

        // Imprimir detalles
        System.out.println("Cliente: " + cliente.getNombre());
        for (Item item : items) {
            System.out.println(item.getNombre() + " x" + item.getCantidad() + ": $" + item.getPrecio());
        }
        System.out.println("Subtotal: $" + (total - impuesto));
        System.out.println("Impuesto (12%): $" + impuesto);
        System.out.println("Total: $" + total);
    }
}