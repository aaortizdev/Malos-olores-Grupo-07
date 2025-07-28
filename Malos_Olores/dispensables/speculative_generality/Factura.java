public class Factura {
    private Descuento descuento;

    public Factura() {
        this.descuento = new SinDescuento();
    }

    public double getTotal(double precio) {
        return descuento.calcularDescuento(precio);
    }
}