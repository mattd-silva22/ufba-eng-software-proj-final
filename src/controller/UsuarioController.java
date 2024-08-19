package src.controller;
import java.util.ArrayList;
import src.model.Usuario;

public class UsuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario buscarUsuarioPorCod(int cod){
        for(Usuario usuario : usuarios){
            if(usuario.getCodigo() == cod){
                return usuario;
            }
        }
        return null;
    }
}
