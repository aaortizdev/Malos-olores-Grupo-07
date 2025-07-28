public class Documento {

    private String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }

    public void imprimir() {
        System.out.println("Imprimiendo: " + contenido);
    }

    public void guardarEnDisco() {
        // lógica para guardar en disco
        System.out.println("Guardando en disco: " + contenido);
    }

    public void enviarPorEmail() {
        // lógica para enviar por email
        System.out.println("Enviando por email: " + contenido);
    }
}