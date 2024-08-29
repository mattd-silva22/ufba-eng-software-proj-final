package src.comands;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import src.di.DependencyInjector;
import src.model.Emprestimo;
import src.model.Livro;
import src.model.Usuario;
import src.view.Display;

public class DevolverExemplarCommand {
    UsuarioController usuarioController = DependencyInjector.getUsuarioController();
    BibliotecaController bibliotecaController = DependencyInjector.getBibliotecaController();
    EmprestimoController emprestimoController = DependencyInjector.getEmprestimoController();
    Display display = DependencyInjector.getDisplay();

    public void execute(int codUsuario, int codLivro){
        Usuario usuario = usuarioController.buscarUsuarioPorCod(codUsuario);
        Livro livro = bibliotecaController.buscarLivroPorCod(codLivro);

        if(usuario == null){
            display.exibirMensagem("Usuário não encontrado" , "Error");
            return;
        }
        if(livro == null){
            display.exibirMensagem("Livro não encontrado", "Error");
            return;
        }
        if(!emprestimoController.temEmprestimoAtivoParaLivro(codUsuario, codLivro)){
            display.exibirMensagem("Usuário não possui empréstimo ativo para este livro" , "Error");
            return;
        }

        Emprestimo emprestimo = emprestimoController.getEmprestimoAtivoParaLivro(codUsuario, codLivro);
        bibliotecaController.devolverExemplar(emprestimo.getExemplar());
        emprestimoController.encerrarEmprestimo(emprestimo);
        display.exibirMensagem("Devolução realizada com sucesso" , "Sucesso");
    }

}
