public class Factura {
    private String fecha;    
    private double monto;   
    private String moneda;     

    public Factura(String fecha, double monto, String moneda) {
        this.fecha = fecha;
        this.monto = monto;
        this.moneda = moneda;
    }

    public boolean esValida() {
        return fecha != null && fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public boolean esMontoValido() {
        return monto >= 0;
    }
}