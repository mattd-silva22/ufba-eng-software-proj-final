package src.controller;
import java.util.ArrayList;

import src.model.TipoUsuario;
import src.model.Usuario;

public class UsuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


    public UsuarioController() {
        // carregar usuarios de teste
        usuarios.add(new Usuario(123, "João da Silva", TipoUsuario.ALUNO));
        usuarios.add(new Usuario(456, "Luiz Fernando Rodrigues", TipoUsuario.ALUNO_POS));
        usuarios.add(new Usuario(789, "Pedro Paulo", TipoUsuario.ALUNO));
        usuarios.add(new Usuario(100, "Carlos Lucena", TipoUsuario.PROFESSOR));
    }


    public Usuario buscarUsuarioPorCod(int cod){
        for(Usuario usuario : usuarios){
            if(usuario.getCodigo() == cod){
                return usuario;
            }
        }
        return null;
    }
}
