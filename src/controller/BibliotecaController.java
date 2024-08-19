package src.controller;

import src.model.Livro;

import java.util.ArrayList;

public class BibliotecaController {
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public Livro buscarLivroPorCod(int cod){
        for(Livro livro : livros){
            if(livro.getCodigo() == cod){
                return livro;
            }
        }
        return null;
    }
}
