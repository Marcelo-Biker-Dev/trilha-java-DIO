package com.treinamento.oo.bancodigitaljava.entities;

import com.treinamento.oo.bancodigitaljava.enums.Agencia;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public abstract class Conta {

    @Id
    protected Integer numeroDeConta;
    protected Agencia agencia;
	protected double saldo;
    protected Date dtCadastro;
    
    @ManyToOne
    @JoinColumn(name="cliente_cpf", nullable=false)
	protected Cliente cliente;

	public Conta() {
    }

    public Conta(Cliente cliente, Agencia agencia) {
		this.agencia = agencia;
		this.cliente = cliente;
		this.dtCadastro = new Date();
        cliente.adicionaConta(this);
	}
    
    public Integer getNumeroDeConta() {
        return numeroDeConta;
    }
    
    public Agencia getAgencia() {
        return agencia;
    }
    
    public Date getDtCadastro() {
        return dtCadastro;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(Long valorDeposito) {
        setSaldo(this.saldo + valorDeposito);
    }
    
    public void sacar(Long valorSaque) {
        this.saldo -= valorSaque;
    }
    
    abstract public String imprimirExtrato();

    protected String imprimirInfosComuns() {
        String infoComum =
        String.format("Titular: %s%n", this.cliente.getNome())+
        String.format("Agencia: %s%n", this.agencia)+
        String.format("Saldo: %.2f%n", this.saldo);
        return infoComum;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getCliente_Cpf(Cliente cliente) {
        return cliente.getCpf();
    }
}
