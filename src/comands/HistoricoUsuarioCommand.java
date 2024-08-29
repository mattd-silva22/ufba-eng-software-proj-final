package src.comands;


import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import src.di.DependencyInjector;
import src.model.Emprestimo;
import src.model.Reserva;
import src.model.Usuario;

import java.util.ArrayList;

public class HistoricoUsuarioCommand {
    UsuarioController usuarioController = DependencyInjector.getUsuarioController();

    EmprestimoController emprestimoController = DependencyInjector.getEmprestimoController();
    view.Display display = DependencyInjector.getDisplay();

    public void execute(int codUsuario) {
        Usuario usuario = usuarioController.buscarUsuarioPorCod(codUsuario);
        if (usuario == null) {
            display.exibirMensagem("Usuário não encontrado", "Error");
            return;
        }

        ArrayList<Emprestimo> emprestimos = emprestimoController.getEmprestimosPorCodUsuario(codUsuario);

        ArrayList<Reserva> reservas = emprestimoController.getReservasPorCodUsuario(codUsuario);

        display.exibirHistoricoUsuario(usuario, emprestimos, reservas);
    }
}
