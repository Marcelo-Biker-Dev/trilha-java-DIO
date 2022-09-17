package com.treinamento.oo.bancodigitaljava.entities;

import com.treinamento.oo.bancodigitaljava.enums.Agencia;

public class ContaCorrente extends Conta {

    public ContaCorrente(Long id, Agencia agencia, int numero, Cliente cliente) {
        super(id, agencia, numero, cliente);
    }

	@Override
	public void imprimirExtrato() {
		System.out.println();
		System.out.println("=== Extrato conta corrente ===");
		super.imprimirInfosComuns();
	}    
}
