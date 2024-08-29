package src.comands;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import src.di.DependencyInjector;

import src.model.Emprestimo;
import src.model.Livro;
import src.model.Reserva;
import src.view.Display;

import java.util.ArrayList;

public class InfoReservaCommand {
    UsuarioController usuarioController = DependencyInjector.getUsuarioController();
    EmprestimoController emprestimoController = DependencyInjector.getEmprestimoController();
    BibliotecaController bibliotecaController = DependencyInjector.getBibliotecaController();
    Display display = DependencyInjector.getDisplay();

   public void execute(int codLivro){
       Livro livro = bibliotecaController.buscarLivroPorCod(codLivro);

       if(livro == null){
           display.exibirMensagem("Livro não encontrado", "Error");
           return;
       }

       ArrayList<Emprestimo> emprestimos = emprestimoController.getEmprestimosPorCodLivro(codLivro);
       ArrayList<Reserva> reservas = emprestimoController.getReservasPorCodLivro(codLivro);

       int quantidadeReservas = reservas.size();
       int quantidadeEmprestimos = emprestimos.size();

       display.exibirResumoInfoReserva(livro, quantidadeReservas, quantidadeEmprestimos);

       if(quantidadeReservas > 0){
           display.exibirMensagem("Reservas: ", "Ultimas Reservas registradas");
           for(Reserva reserva : reservas){
               display.exibirReserva(reserva);
           }
       }

         if(quantidadeEmprestimos > 0){
              display.exibirMensagem("Emprestimos: ", "Ultimos Emprestimos registrados");
              for(Emprestimo emprestimo : emprestimos){
                display.exibirEmprestimo(emprestimo);
              }
         }

   }
}
