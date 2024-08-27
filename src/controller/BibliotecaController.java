package src.controller;

import src.model.Exemplar;
import src.model.Livro;
import src.model.StatusExemplar;

import java.util.ArrayList;

public class BibliotecaController {
    private ArrayList<Livro> livros = new ArrayList<Livro>();
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    public Livro buscarLivroPorCod(int cod){
        for(Livro livro : livros){
            if(livro.getCodigo() == cod){
                return livro;
            }
        }
        return null;
    }

    public Exemplar buscarExemplarPorCod(int cod){
        for(Exemplar exemplar : exemplares){
            if(exemplar.getCodigo() == cod){
                return exemplar;
            }
        }
        return null;
    }

    public boolean temExemplarDisponivel(int codLivro){
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getLivro().getCodigo() == codLivro && exemplar.getStatus().equals(StatusExemplar.DISPONIVEL)) {
                return true;
            }
        }
        return false;
    }

    public Exemplar getExemplarDisponivel(Livro livro){
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getLivro().equals(livro) && exemplar.getStatus().equals(StatusExemplar.DISPONIVEL)) {
                return exemplar;
            }
        }
        return null;
    }
}
