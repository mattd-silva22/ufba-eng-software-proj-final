package src.model;
import java.util.Date;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private Date dataEmprestimo;


    public Emprestimo(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = new Date();
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }


}