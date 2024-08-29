package src.controller;

import src.model.Exemplar;
import src.model.Livro;
import src.model.StatusExemplar;

import java.util.ArrayList;

public class BibliotecaController {
    private ArrayList<Livro> livros = new ArrayList<Livro>();
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();


    public BibliotecaController(){
        livros.add(new Livro(100, "Engenharia de Software", "Addison-Wesley", "Ian Sommerville", 6, 2000, 1));
        livros.add(new Livro(101, "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", 7, 2000, 1));
        livros.add(new Livro(200, "Code Complete", "Microsoft Press", "Steve McConnell", 2, 2014, 1));
        livros.add(new Livro(201, "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", 1, 2002, 1));
        livros.add(new Livro(300, "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", 1, 1999, 1));
        livros.add(new Livro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", 3, 2014, 1));
        livros.add(new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1, 1994, 1));
        livros.add(new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", 3, 2003, 1));

        exemplares.add(new Exemplar(1, livros.get(0), StatusExemplar.DISPONIVEL));  // Engenharia de Software
        exemplares.add(new Exemplar(2, livros.get(0), StatusExemplar.DISPONIVEL));  // Engenharia de Software
        exemplares.add(new Exemplar(3, livros.get(1), StatusExemplar.DISPONIVEL));  // UML – Guia do Usuário
        exemplares.add(new Exemplar(4, livros.get(2), StatusExemplar.DISPONIVEL));  // Code Complete
        exemplares.add(new Exemplar(5, livros.get(3), StatusExemplar.DISPONIVEL));  // Agile Software Development
        exemplares.add(new Exemplar(6, livros.get(4), StatusExemplar.DISPONIVEL));  // Refactoring
        exemplares.add(new Exemplar(7, livros.get(4), StatusExemplar.DISPONIVEL));  // Refactoring
        exemplares.add(new Exemplar(8, livros.get(5), StatusExemplar.DISPONIVEL));  // Design Patterns
        exemplares.add(new Exemplar(9, livros.get(5), StatusExemplar.DISPONIVEL));  // Design Patterns

    }
    public Livro buscarLivroPorCod(int cod){
        for(Livro livro : livros){
            if(livro.getCodigo() == cod){
                return livro;
            }
        }
        return null;
    }


    public boolean temExemplarDisponivel(int codLivro){
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getLivro().getCodigo() == codLivro && exemplar.disponivelParaEmprestimo()) {
                return true;
            }
        }
        return false;
    }

    public Exemplar getExemplarDisponivel(Livro livro){
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getLivro().equals(livro) && exemplar.disponivelParaEmprestimo()) {
                return exemplar;
            }
        }
        return null;
    }

    public void reservarExemplar(Exemplar exemplar) {
        for (Exemplar ex : exemplares) {
            if (ex.getCodigo() == exemplar.getCodigo()) {
                ex.reservar();
            }
        }
    }

    public void devolverExemplar(Exemplar exemplar){
        for (Exemplar ex : exemplares) {
            if (ex.getCodigo() == exemplar.getCodigo()) {
                ex.devolver();
            }
        }
    }

    public void emprestarExemplar(Exemplar exemplar){
            for (Exemplar ex : exemplares) {
                if (ex.getCodigo() == exemplar.getCodigo()) {
                    ex.emprestar();
                }
            }
        }

    public ArrayList<Exemplar> getExemplares(){
        return exemplares;
    }
}
