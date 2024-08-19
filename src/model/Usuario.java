package src.model;

import java.util.Collection;


public class Usuario {
    private int codigo;
    private String nome;
    private TipoUsuario tipo;
    private RegrasUsuario regras;

    public Usuario(int codigo, String nome, TipoUsuario tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.regras = new RegrasUsuario(tipo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public RegrasUsuario getRegras() {
        return regras;
    }

}