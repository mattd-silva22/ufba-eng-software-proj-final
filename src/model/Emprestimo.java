package src.model;
import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;


    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }


}