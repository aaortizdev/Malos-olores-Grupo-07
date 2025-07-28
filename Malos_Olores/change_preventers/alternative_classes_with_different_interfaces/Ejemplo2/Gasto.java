public class Gasto {
    private double valor;
    private String tipoCategoria;

    public Gasto(double valor, String tipoCategoria) {
        this.valor = valor;
        this.tipoCategoria = tipoCategoria;
    }

    public double getValor() {
        return valor;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void registrarGasto() {
        System.out.println("Registrando gasto de: " + valor);
    }
}