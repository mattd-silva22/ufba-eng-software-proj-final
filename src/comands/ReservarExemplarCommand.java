package src.comands;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import src.di.DependencyInjector;
import src.model.Exemplar;
import src.model.Livro;
import src.model.Reserva;
import src.model.Usuario;
import src.view.Display;

public class ReservarExemplarCommand  {
    UsuarioController usuarioController = DependencyInjector.getUsuarioController();
    BibliotecaController bibliotecaController = DependencyInjector.getBibliotecaController();
    EmprestimoController emprestimoController = DependencyInjector.getEmprestimoController();
    Display display = DependencyInjector.getDisplay();


    public void execute(int codUsuario , int codLivro){ {
        Usuario usuario = usuarioController.buscarUsuarioPorCod(codUsuario);
        Livro livro = bibliotecaController.buscarLivroPorCod(codLivro);
        if(usuario == null){
            display.exibirMensagem("Usuário não encontrado" , "Error");
            return;
        }
        if(livro == null){
            display.exibirMensagem("Livro não encontrado" , "Error");
            return;
        }
        if(emprestimoController.temEmprestimoAtivoParaLivro(codUsuario, codLivro)){
            display.exibirMensagem("Usuário já possui empréstimo ativo para este livro" , "Error");
            return;
        }

        Exemplar exemplar = bibliotecaController.getExemplarDisponivel(livro);

        if(exemplar == null){
            display.exibirMensagem("Não há exemplares disponiveis para reserva" , "Error");
            return;
        }

        Reserva reserva = new Reserva(exemplar, usuario);
        bibliotecaController.reservarExemplar(exemplar);
        emprestimoController.adicionarReserva(reserva);

        display.exibirReservaSucesso(usuario, livro);
    }
    }


}
