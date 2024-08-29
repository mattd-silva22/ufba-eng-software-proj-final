package src.model;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolucaoPrevista;
    private StatusEmprestimo status;


    public Emprestimo(Exemplar exemplar, Usuario usuario) {

        LocalDate dataAtual = LocalDate.now();
        int diasEmprestimo = usuario.getRegras().tempoMaximoEmprestimo;


        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = dataAtual;
        this.dataDevolucaoPrevista = dataAtual.plus(diasEmprestimo, ChronoUnit.DAYS);
        this.status = StatusEmprestimo.ATIVO;

    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void devolver() {
        this.status = StatusEmprestimo.DEVOLVIDO;
        this.dataDevolucao = LocalDate.now();
    }

    public void atrasar() {
        this.status = StatusEmprestimo.ATRASO;
    }

    public boolean isAtivo() {
        return this.status == StatusEmprestimo.ATIVO;
    }

    public boolean isAtrasado() {
        return this.status == StatusEmprestimo.ATRASO;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }


}