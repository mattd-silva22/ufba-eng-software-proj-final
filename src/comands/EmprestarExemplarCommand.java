package src.comands;

import src.di.DependencyInjector;
import src.model.Emprestimo;
import src.model.Exemplar;
import src.model.Livro;
import src.model.Usuario;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import view.Display;
import src.di.DependencyInjector;


public class EmprestarExemplarCommand {

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
        if(emprestimoController.temEmprestimoAtivoParaLivro(codUsuario, codLivro)){
            display.exibirMensagem("Usuário já possui empréstimo ativo para este livro" , "Error");
            return;
        }

        if(!emprestimoController.usuarioApitoParaEmprestimo(usuario)){
            display.exibirMensagem("Usuário não pode realizar empréstimo" , "Error");
            return;
        }

        if(!bibliotecaController.temExemplarDisponivel(codLivro)){
            display.exibirMensagem("Não há exemplares disponíveis para empréstimo" , "Error");
            return;
        }

        Exemplar exemplar = bibliotecaController.getExemplarDisponivel(livro);

        if(exemplar == null){
            display.exibirMensagem("Exemplar não encontrado" , "Error");
            return;
        }

        bibliotecaController.emprestarExemplar(exemplar);

        Emprestimo emprestimo = new Emprestimo(exemplar, usuario);
        emprestimoController.adicionarEmprestimo(emprestimo);
        display.exibirEmprestimoSucesso(usuario, livro);
    }
}
