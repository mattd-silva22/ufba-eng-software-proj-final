package view;

import src.model.Livro;
import src.model.Usuario;

public class Display {


    public void menuPrincipal(){
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Cadastrar Usuario");
        System.out.println("3 - Emprestimo");
        System.out.println("4 - Devolucao");
        System.out.println("5 - Reserva");
        System.out.println("6 - Sair");
    }

    public void exibirLivro(Livro livro){
        System.out.println("Codigo: " + livro.getCodigo());
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutores());
        System.out.println("Ano: " + livro.getAnoPublicacao());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Edicao: " + livro.getEdicao());
        

    }

    public void exibirEmprestimoSucesso(Usuario usuario , Livro livro){
        System.out.println("Emprestimo realizado com sucesso");
    }

    public void exibirEmprestimoErro(Usuario usuario , Livro livro){
        System.out.println("Emprestimo não realizado");
    }

    public void exibirMensagem(String msg){
        System.out.println(msg);
    }
}
