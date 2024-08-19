package src.controller;

import src.model.Emprestimo;
import src.model.Livro;
import src.model.Reserva;
import src.model.Usuario;
import java.util.ArrayList;


public class EmprestimoController {
   private  ArrayList<Emprestimo> emprestimos;
   private ArrayList<Reserva> reservas;

   public ArrayList<Emprestimo> getEmprestimoPorCodUsuario(int codUsuario){

       ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();

       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario) {
               emprestimosDoUsuario.add(emprestimo);
           }

       }
       return emprestimosDoUsuario;
   }


   public boolean temEmprestimoAtivoParaLivro(int codUsuario, int codLivro){

       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario && emprestimo.getLivro().getCodigo() == codLivro) {
               return true;
           }

       }
       return false;
   }

    private int contarEmprestimosAtivos(int codUsuario) {
        int totalEmprestimos = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getCodigo() == codUsuario) {
                totalEmprestimos++;
            }
        }
        return totalEmprestimos;
    }

   public boolean usuarioApitoParaEmprestimo(Usuario usuario){
       boolean dentroDoLimite = this.contarEmprestimosAtivos(usuario.getCodigo()) < usuario.getRegras().quantidadeMaximaEmprestimos;
       boolean semEmprestimosAtrasados = this.getEmprestimosAtrasados(usuario.getCodigo()) == 0;
       return dentroDoLimite && semEmprestimosAtrasados;
   }


   public void getEmprestimoPorCodLivro(){
       return;
   }

   public void getEmprestimoPorCodExemplar(){
       return;
   }

   public void adicionarEmprestimo(Emprestimo emprestimo){
       if(this.temReserva(emprestimo.getLivro(), emprestimo.getUsuario())){
              this.encerrarReserva(emprestimo.getLivro(), emprestimo.getUsuario());
       }
       emprestimos.add(emprestimo);
   }

   public void encerrarEmprestimo(){
       return;
   }

   private int getEmprestimosAtrasados(int codUsuario){
       return 1;
   }

    public void adicionarReserva(Reserva reserva){
         reservas.add(reserva);
    }

    public void encerrarReserva(Livro livro, Usuario usuario) {
        reservas.removeIf(reserva -> reserva.getUsuario().getCodigo() == usuario.getCodigo() && reserva.getLivro().getCodigo() == livro.getCodigo());
    }


    public boolean temReserva(Livro livro, Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().getCodigo() == usuario.getCodigo() &&
                    reserva.getLivro().getCodigo() == livro.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}

