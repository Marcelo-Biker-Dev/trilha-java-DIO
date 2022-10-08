package com.treinamento.oo.bancodigitaljava.enums;

public enum Agencia {
    
    LISBOA (01),
    PORTO (02),
    BRAGA (04),
    FARO (05);
    
    private int numero;

    private Agencia(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
}
