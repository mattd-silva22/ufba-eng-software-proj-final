package src.comands;

import src.controller.BibliotecaController;
import src.di.DependencyInjector;

public class ExibirExemplaresCommand {
    BibliotecaController bibliotecaController = DependencyInjector.getBibliotecaController();
    view.Display display = DependencyInjector.getDisplay();
    public void execute(){
        display.exibirExemplares(bibliotecaController.getExemplares());

    }
}
