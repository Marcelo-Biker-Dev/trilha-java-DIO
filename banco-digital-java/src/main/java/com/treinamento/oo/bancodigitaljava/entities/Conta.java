package com.treinamento.oo.bancodigitaljava.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.treinamento.oo.bancodigitaljava.enums.Agencia;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
@Table(name="tb_contas")
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected Agencia agencia;
	protected int numeroDeConta;
	protected double saldo = 0;
    
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
	protected Cliente cliente;

	protected Conta(Long id, Agencia agencia, int numero, Cliente cliente) {
        this.id = id;
		this.agencia = agencia;
        this.numeroDeConta = numero;
		this.cliente = cliente;
	}

	protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %s", this.agencia));
        System.out.println(String.format("Numero: %d", this.numeroDeConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirExtrato() {};
}
