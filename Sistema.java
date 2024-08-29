import java.util.ArrayList;
import java.util.Scanner;

import src.comands.*;
import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.model.*;
import src.view.Display;
import src.controller.UsuarioController;

public class Sistema {
    private static Display display = new Display();
    private static Scanner scanner = new Scanner(System.in);


    private static EmprestarExemplarCommand emprestarExemplarCommand = new EmprestarExemplarCommand();
    private static HistoricoUsuarioCommand historicoUsuarioCommand = new HistoricoUsuarioCommand();
    private static ReservarExemplarCommand reservarExemplarCommand = new ReservarExemplarCommand();
    private static DevolverExemplarCommand devolverExemplarCommand = new DevolverExemplarCommand();
    private static ExibirExemplaresCommand exibirExemplaresCommand = new ExibirExemplaresCommand();
    private static InfoReservaCommand infoReservaCommand = new InfoReservaCommand();
    private static String[] lerComando(){
        String comando = scanner.nextLine();
        return comando.split(" ");
    }

    private static void execultaComando(String[] partes){
        String acao = partes[0];
        switch (acao){
            case "emp": //emprestar
                emprestarExemplarCommand.execute(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "res": //reservar
                reservarExemplarCommand.execute(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "dev": //devolver
                devolverExemplarCommand.execute(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "obs": //observar
                break;
            case "nth": //notificacoes
                break;
            case "usu": //historico
                historicoUsuarioCommand.execute(Integer.parseInt(partes[1]));
                break;
            case "liv": //consultar
                infoReservaCommand.execute(Integer.parseInt(partes[1]));
                break;
            case "exemp"://exemplar
                exibirExemplaresCommand.execute();
                break;
            case "sai":
                System.exit(0);
                break;
            default:
                display.exibirMensagem("Comando inválido" , "Error");
        }
    }


   public static void main(String[] args){
        while(true){
            display.menuPrincipal();
            String[] partes = lerComando();
            execultaComando(partes);
        }



   }
    
}
