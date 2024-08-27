package src.model;

public class Exemplar {
    private int codigo;
    private Livro livro;
    private StatusExemplar status;



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
}
