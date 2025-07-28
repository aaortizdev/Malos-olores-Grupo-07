public class AuthService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean autenticar(String username, String password) {
        Usuario user = usuarioDAO.buscarPorUsuario(username);
        return user != null && user.verificarPassword(password);
    }
    
    public boolean estaRegistrado(String email) {
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}