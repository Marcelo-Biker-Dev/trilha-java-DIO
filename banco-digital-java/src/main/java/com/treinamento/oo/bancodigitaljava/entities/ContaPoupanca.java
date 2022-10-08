package com.treinamento.oo.bancodigitaljava.entities;

import com.treinamento.oo.bancodigitaljava.enums.Agencia;

import javax.persistence.Entity;

@Entity
public class ContaPoupanca extends Conta {

	private static int numeroInicial = 500000;
	
	public ContaPoupanca() {
	}
	
    public ContaPoupanca(Cliente cliente, Agencia agencia) {
        super(cliente, agencia);
		this.numeroDeConta = setNumeroDeConta();
    }
	
	private int setNumeroDeConta() {
		return ++numeroInicial;
	}

	public String imprimirExtrato() {
		String extrato =
		"\n"+"=== Extrato conta poupança ==="+
		"\n"+super.imprimirInfosComuns();
		return extrato;
	}
}
//private int numeroDeConta;

/*public int getNumeroDeConta() {
	return numeroDeConta;
}*/
