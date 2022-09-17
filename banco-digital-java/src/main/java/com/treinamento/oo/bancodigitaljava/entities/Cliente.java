package com.treinamento.oo.bancodigitaljava.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
@Table(name="tb_clientes")
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String celular;


   /* @OneToMany
    @JoinColumn(name = "conta_id")
	private Conta conta;*/

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
