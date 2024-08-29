package src.model;

public class RegrasUsuario {

    public int tempoMaximoEmprestimo;
    public int  quantidadeMaximaEmprestimos;

    public RegrasUsuario(TipoUsuario tipo) {
        this.tempoMaximoEmprestimo = getTempoMaximoEmprestimo(tipo);
        this.quantidadeMaximaEmprestimos = getQuantidadeMaximaEmprestimos(tipo);
    }


    // Método único que trata as regras de todos os tipos de usuário
    private int getTempoMaximoEmprestimo(TipoUsuario tipo) {
        switch (tipo) {
            case TipoUsuario.PROFESSOR:
                return 7;  
            case TipoUsuario.ALUNO:
                return 3;
            case TipoUsuario.ALUNO_POS:
                return 5;
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);
        }
    }

    private int getQuantidadeMaximaEmprestimos(TipoUsuario tipo) {
        switch (tipo) {
            case TipoUsuario.PROFESSOR:
                return Integer.MAX_VALUE;  
            case TipoUsuario.ALUNO:
                return 3;
            case TipoUsuario.ALUNO_POS:
                return 4;
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);
        }
    }


}