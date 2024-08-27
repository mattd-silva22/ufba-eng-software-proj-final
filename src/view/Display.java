package view;

import src.model.Livro;
import src.model.Usuario;

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

    public void exibirEmprestimoSucesso(Usuario usuario , Livro livro){
        System.out.println("Emprestimo realizado com sucesso");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Livro: " + livro.getTitulo());
    }

    public void exibirEmprestimoErro(Usuario usuario , Livro livro){
        System.out.println("Emprestimo não realizado");
    }

    public void exibirMensagem(String msg){
        System.out.println(msg);
    }
}
