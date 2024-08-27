import java.util.Scanner;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.model.Emprestimo;
import src.model.Exemplar;
import src.model.Livro;
import src.model.Usuario;
import view.Display;
import src.controller.UsuarioController;

public class Sistema {
    private static Display display = new Display();
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioController usuarioController = new UsuarioController();
    private static BibliotecaController bibliotecaController = new BibliotecaController();
    private static EmprestimoController emprestimoController = new EmprestimoController();


    private static String[] lerComando(){
        String comando = scanner.nextLine();
        return comando.split(" ");
    }

    private static void execultaComando(String[] partes){
        String acao = partes[0];
        switch (acao){
            case "emp": //emprestar
                emprestarLivro(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "res": //reservar
                reservarLivro(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "dev": //devolver
                break;
            case "obs": //observar
                break;
            case "liv": //consultar
                break;
            case "sair":
                System.exit(0);
                break;
            default:
                display.exibirMensagem("Comando inválido");
        }
    }

    private static void emprestarLivro(int codUsuario, int codLivro){

        Usuario usuario = usuarioController.buscarUsuarioPorCod(codUsuario);
        Livro livro = bibliotecaController.buscarLivroPorCod(codLivro);

        if(usuario == null){
            display.exibirMensagem("Usuário não encontrado");
            return;
        }
        if(livro == null){
            display.exibirMensagem("Livro não encontrado");
            return;
        }
        if(emprestimoController.temEmprestimoAtivoParaLivro(codUsuario, codLivro)){
            display.exibirMensagem("Usuário já possui empréstimo ativo para este livro");
            return;
        }

        if(emprestimoController.usuarioApitoParaEmprestimo(usuario)){
            display.exibirMensagem("Usuário não pode realizar empréstimo");
            return;
        }

        if(!bibliotecaController.temExemplarDisponivel(codLivro)){
            display.exibirMensagem("Não há exemplares disponíveis para empréstimo");
            return;
        }

        Exemplar exemplar = bibliotecaController.getExemplarDisponivel(livro);

        if(exemplar == null){
            display.exibirMensagem("Exemplar não encontrado");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(exemplar, usuario);
        emprestimoController.adicionarEmprestimo(emprestimo);
        display.exibirMensagem("Empréstimo realizado com sucesso");
        display.exibirEmprestimoSucesso(usuario, livro);
    }

    private static void reservarLivro(int codUsuario, int codLivro){
        Usuario usuario = usuarioController.buscarUsuarioPorCod(codUsuario);
        Livro livro = bibliotecaController.buscarLivroPorCod(codLivro);
        if(usuario == null){
            display.exibirMensagem("Usuário não encontrado");
            return;
        }
        if(livro == null){
            display.exibirMensagem("Livro não encontrado");
            return;
        }
        if(emprestimoController.temEmprestimoAtivoParaLivro(codUsuario, codLivro)){
            display.exibirMensagem("Usuário já possui empréstimo ativo para este livro");
            return;
        }
    }

   public static void main(String[] args){
        display.menuPrincipal();
        String[] partes = lerComando();
        execultaComando(partes);


   }
    
}
