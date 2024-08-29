package src.model;

public class Exemplar {
    private int codigo;
    private Livro livro;
    private StatusExemplar status;

    public Exemplar(int codigo, Livro livro, StatusExemplar status) {
        this.codigo = codigo;
        this.livro = livro;
        this.status = status;
    }


    public int getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public StatusExemplar getStatus() {
        return status;
    }

    public void setStatus(StatusExemplar status) {
        this.status = status;
    }

    public void emprestar() {
        this.status = StatusExemplar.EMPRESTADO;
    }

    public void devolver() {
        this.status = StatusExemplar.DISPONIVEL;
    }

    public void reservar() {
        this.status = StatusExemplar.RESERVADO;
    }

    public boolean disponivelParaEmprestimo() {
        return this.status == StatusExemplar.DISPONIVEL;
    }

}
