package src.controller;

import src.model.Emprestimo;
import src.model.Livro;
import src.model.Reserva;
import src.model.Usuario;
import java.util.ArrayList;


public class EmprestimoController {
   private  ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
   private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

   public ArrayList<Emprestimo> getEmprestimosPorCodUsuario(int codUsuario){

       ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();

       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario) {
               emprestimosDoUsuario.add(emprestimo);
           }

       }
       return emprestimosDoUsuario;
   }

   public ArrayList<Reserva> getReservasPorCodUsuario(int codUsuario){
       ArrayList<Reserva> reservasDoUsuario = new ArrayList<Reserva>();
       for (Reserva reserva : reservas) {
           if (reserva.getUsuario().getCodigo() == codUsuario) {
               reservasDoUsuario.add(reserva);
           }
       }
       return reservasDoUsuario;
   }

   public ArrayList<Reserva> getReservasPorCodLivro(int codLivro){
       ArrayList<Reserva> reservasDoLivro = new ArrayList<Reserva>();
       for (Reserva reserva : reservas) {
           if (reserva.getExemplar().getLivro().getCodigo() == codLivro) {
               reservasDoLivro.add(reserva);
           }
       }
       return reservasDoLivro;
   }

   public ArrayList<Emprestimo> getEmprestimosPorCodLivro(int codLivro){
       ArrayList<Emprestimo> emprestimosDoLivro = new ArrayList<Emprestimo>();
       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getExemplar().getLivro().getCodigo() == codLivro) {
               emprestimosDoLivro.add(emprestimo);
           }
       }
       return emprestimosDoLivro;
   }


   public boolean temEmprestimoAtivoParaLivro(int codUsuario, int codLivro){

       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario && emprestimo.getExemplar().getLivro().getCodigo() == codLivro && emprestimo.isAtivo()) {
               return true;
           }

       }
       return false;
   }

   public Emprestimo getEmprestimoAtivoParaLivro(int codUsuario, int codLivro) {
       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario && emprestimo.getExemplar().getLivro().getCodigo() == codLivro) {
               return emprestimo;
           }
       }
       return null;
   }

    private int contarEmprestimosAtivos(int codUsuario) {
        int totalEmprestimos = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getCodigo() == codUsuario && emprestimo.isAtivo()) {
                totalEmprestimos++;
            }
        }
        return totalEmprestimos;
    }

   public boolean usuarioApitoParaEmprestimo(Usuario usuario){
       boolean dentroDoLimite = this.contarEmprestimosAtivos(usuario.getCodigo()) < usuario.getRegras().quantidadeMaximaEmprestimos;
       boolean semEmprestimosAtrasados = this.getEmprestimosAtrasados(usuario.getCodigo()) == 0;

       if(!dentroDoLimite){
           System.out.println("Usuário atingiu o limite de empréstimos ativos");
       }

         if(!semEmprestimosAtrasados){
              System.out.println("Usuário possui empréstimos atrasados");
         }

       return dentroDoLimite && semEmprestimosAtrasados;
   }




   public void adicionarEmprestimo(Emprestimo emprestimo){
       if(this.temReserva(emprestimo.getExemplar().getLivro(), emprestimo.getUsuario())){
              this.encerrarReserva(emprestimo.getExemplar().getLivro(), emprestimo.getUsuario());
       }
       emprestimos.add(emprestimo);
   }

   public void encerrarEmprestimo(Emprestimo emprestimo){
       for(Emprestimo emp : emprestimos){
           if(emp.getExemplar().getCodigo() == emprestimo.getExemplar().getCodigo()){
               emp.devolver();
           }
       }

   }


   private int getEmprestimosAtrasados(int codUsuario){
       int totalAtrasos = 0;
       for (Emprestimo emprestimo : emprestimos) {
           if (emprestimo.getUsuario().getCodigo() == codUsuario && emprestimo.isAtrasado()) {
               totalAtrasos++;
           }
       }
       return totalAtrasos;
   }

    public void adicionarReserva(Reserva reserva){
         reservas.add(reserva);
    }

    public void encerrarReserva(Livro livro, Usuario usuario) {
        reservas.removeIf(reserva -> reserva.getUsuario().getCodigo() == usuario.getCodigo() && reserva.getExemplar().getLivro().getCodigo() == livro.getCodigo());
    }

    public boolean temReserva(Livro livro, Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().getCodigo() == usuario.getCodigo() &&
                    reserva.getExemplar().getLivro().getCodigo() == livro.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}

