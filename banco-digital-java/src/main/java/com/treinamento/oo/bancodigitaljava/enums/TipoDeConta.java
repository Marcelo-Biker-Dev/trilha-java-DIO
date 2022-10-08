package com.treinamento.oo.bancodigitaljava.enums;

public enum TipoDeConta {
    
    CC ("Conta corrente", 10),
    POUPANCA ("Conta poupança", 50);

    private String descricao;
    private int codigo;

    private TipoDeConta(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    
}
