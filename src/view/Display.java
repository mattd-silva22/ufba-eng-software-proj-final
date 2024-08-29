package src.view;

import src.model.*;

import java.util.ArrayList;

public class Display {


    public void menuPrincipal(){
        System.out.println("Empréstimo: emp cod_usuario cod_livro");
        System.out.println("Devolução: dev cod_usuario cod_livro");
        System.out.println("Reservar: res cod_usuario cod_livro");
        System.out.println("Observar: obs cod_usuario cod_livro");
        System.out.println("Consultar: liv cod_livro");
        System.out.println("Notificações: nth cod_usuario");
        System.out.println("Historico: usu cod_usuario");
        System.out.println("Sair: sai");
    }

    public void exibirLivro(Livro livro){
        System.out.println("Codigo: " + livro.getCodigo());
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutores());
        System.out.println("Ano: " + livro.getAnoPublicacao());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Edicao: " + livro.getEdicao());
    }

    public void exibirReserva(Reserva reserva){
        System.out.println("Livro: " + reserva.getExemplar().getLivro().getTitulo());
        System.out.println("Data reserva: " + reserva.getDataReserva());
        System.out.println("Usuario: " + reserva.getUsuario().getNome());
        System.out.println("________________________________");
    }

    public void exibirEmprestimo(Emprestimo emprestimo){
        System.out.println("Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
        System.out.println("Data emprestimo: " + emprestimo.getDataEmprestimo());
        System.out.println("Devolução prevista: " + emprestimo.getDataDevolucaoPrevista());
        System.out.println("Data devolução: " + emprestimo.getDataDevolucao());
        System.out.println("Usuario: " + emprestimo.getUsuario().getNome());
        System.out.println("Status: " + emprestimo.getStatus());
        System.out.println("________________________________");
    }
    public void exibirResumoInfoReserva(Livro livro , int quantidadeReservas, int quantidadeEmprestimos){
        System.out.println("### " + livro.getTitulo() + " ###");
        System.out.println("Quantidade de reservas: " + quantidadeReservas);
        System.out.println("Quantidade de emprestimos: " + quantidadeEmprestimos);
        System.out.println("________________________________");
    }

    public void exibirHistoricoUsuario(Usuario usuario, ArrayList<Emprestimo> emprestimos, ArrayList<Reserva> reservas){
        System.out.println("____________ Historico ____________");
        System.out.println("Historico do usuário: " + usuario.getNome());
        System.out.println("Emprestimos:");
        System.out.println("________________________________");

        if(emprestimos.isEmpty()){
            System.out.println("Nenhum emprestimo");
            System.out.println("________________________________");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
                System.out.println("Data emprestimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Devolução prevista: " + emprestimo.getDataDevolucaoPrevista());
                System.out.println("Data devolução: " + emprestimo.getDataDevolucao());
                System.out.println("Status: " + emprestimo.getStatus());
                System.out.println("________________________________");
            }
        }


        System.out.println("Reservas:");
        if (reservas.isEmpty()){
            System.out.println("Nenhuma reserva");
            System.out.println("________________________________");
        } else {
            System.out.println("Reservas:");
            for (Reserva reserva : reservas) {
                System.out.println("Livro: " + reserva.getExemplar().getLivro().getTitulo());
                System.out.println("Data reserva: " + reserva.getDataReserva());
                System.out.println("________________________________");
            }
        }


    }

    public void exibirEmprestimoSucesso(Usuario usuario , Livro livro){
        System.out.println("### Emprestimo realizado com sucesso ###");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("________________________________");
    }



    public void exibirReservaSucesso(Usuario usuario , Livro livro){
        System.out.println("### Reserva realizada com sucesso ###");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("________________________________");
    }

    public void exibirMensagem(String msg, String titulo){
        System.out.println("### " + titulo + " ###");
        System.out.println(msg);
        System.out.println("________________________________");
    }

    public void exibirExemplares(ArrayList<Exemplar> exemplares){
        System.out.println("### Exemplares ###");
        for (Exemplar exemplar : exemplares) {
            System.out.println("Livro: " + exemplar.getLivro().getTitulo());
            System.out.println("Codigo: " + exemplar.getCodigo());
            System.out.println("Status: " + exemplar.getStatus());
            System.out.println("________________________________");
        }
    }
}
