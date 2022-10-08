package com.treinamento.oo.bancodigitaljava.entities;

import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String celular;

    @OneToMany //(cascade = CascadeType.ALL)
    @JoinTable(name="cliente_contas",
        joinColumns = @JoinColumn(name="cliente_cpf"),
        inverseJoinColumns = @JoinColumn(name="conta_numeroDeConta"))
    private List<Conta> contas = new ArrayList<>();

    public Cliente() {
    }
    
    public Cliente(String cpf, String nome, String celular) {
        this.cpf = cpf;
        this.celular= celular;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public void adicionaConta(Conta conta){
        this.contas.add(conta);
        conta.setCliente(this);
    }
    
    public List<Conta> getContas() {
        List<Conta> contasRespectivas = Collections.unmodifiableList(this.contas);
      return contasRespectivas;
    }
}
