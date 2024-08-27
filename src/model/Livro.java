package src.model;

public class Livro {
    private int codigo ;
    private int codigoExemplar;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int anoPublicacao;
    private int disponivelParaEmprestimo;

    public Livro(int codigo ,String titulo, String editora, String autores, int edicao, int anoPublicacao, int codigoExemplar) {
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.codigo = codigo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
    }
    
    public void setCodigoExemplar(int codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDisponivelParaEmprestimo() {
        return disponivelParaEmprestimo;
    }

    public void setDisponivelParaEmprestimo(int disponivelParaEmprestimo) {
        this.disponivelParaEmprestimo = disponivelParaEmprestimo;
    }
}
