package src.di;

import src.controller.BibliotecaController;
import src.controller.EmprestimoController;
import src.controller.UsuarioController;
import src.view.Display;

public class DependencyInjector {
    private static UsuarioController usuarioController;
    private static BibliotecaController bibliotecaController;
    private static EmprestimoController emprestimoController;
    private static Display display;

    static {
        usuarioController = new UsuarioController();
        bibliotecaController = new BibliotecaController();
        emprestimoController = new EmprestimoController();
        display = new Display();
    }

    public static UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public static BibliotecaController getBibliotecaController() {
        return bibliotecaController;
    }

    public static EmprestimoController getEmprestimoController() {
        return emprestimoController;
    }

    public static Display getDisplay() {
        return display;
    }
}