public class Usuario {
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public boolean autenticar(String contrasenaIngresada) {
        return this.contrasena.equals(contrasenaIngresada);
    }

    public boolean validarEmail() {
        return email != null && email.contains("@");
    }

    public void enviarCorreoBienvenida() {
        System.out.println("Enviando correo de bienvenida a " + email);
    }

    public void guardarEnBD() {
        System.out.println("Guardando usuario " + nombre + " en la base de datos.");
    }
}