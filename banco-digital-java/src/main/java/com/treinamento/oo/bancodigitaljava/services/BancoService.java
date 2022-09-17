package com.treinamento.oo.bancodigitaljava.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.treinamento.oo.bancodigitaljava.entities.Cliente;
import com.treinamento.oo.bancodigitaljava.entities.Conta;
import com.treinamento.oo.bancodigitaljava.entities.ContaCorrente;
import com.treinamento.oo.bancodigitaljava.entities.ContaPoupanca;
import com.treinamento.oo.bancodigitaljava.enums.Agencia;
import com.treinamento.oo.bancodigitaljava.enums.TipoDeConta;

@Service
public class BancoService {

    private Conta conta;
    private Cliente cliente;
    private static int NUMERO_DE_CONTA_CORRENTE = 100000;
    private static int NUMERO_DE_CONTA_POUPANCA = 500000;


    Scanner sc = new Scanner(System.in);

    public void abreConta() {
        System.out.println("Olá! Digite seu nome: ");
        String nome = sc.next();

        System.out.println(nome +", quer abrir conta corrente ou poupança?\n Responda CC para conta corrente, ou responda POUPANCA para conta poupança: ");
        String tipoConta = sc.next().toUpperCase();

        System.out.println("Por favor, digite seu CPF: ");
        String cpf = sc.next();

        System.out.println("Para concluir, escolha uma agência: (Lisboa, Porto, Braga ou Faro)");
        String agenciaEscolhida = sc.next().toUpperCase();
        
        setCliente(nome, cpf);

        Agencia agencia = null;
        
        for (Agencia ag : Agencia.values()) {
            if (ag.toString().equals(agenciaEscolhida)) {
                agencia = ag;
            } 
        }

        if (TipoDeConta.CC.toString().equals(tipoConta)) {
            gerarNumeroDeConta(TipoDeConta.CC.getCodigo());
            setCC(null, agencia, NUMERO_DE_CONTA_CORRENTE, cliente);
            conta.imprimirExtrato();
        }
        else if (TipoDeConta.POUPANCA.toString().equals(tipoConta)) {
            gerarNumeroDeConta(TipoDeConta.POUPANCA.getCodigo());
            setCP(null, agencia, NUMERO_DE_CONTA_POUPANCA, cliente);
            conta.imprimirExtrato();
        }
    }

    private Cliente setCliente(String nome, String cpf) {
        return cliente = new Cliente(cpf, nome);
    }

    private int gerarNumeroDeConta(int tipoConta) {
        if (tipoConta == 10) {
            NUMERO_DE_CONTA_CORRENTE++;
            return NUMERO_DE_CONTA_CORRENTE;
        }
        else {
            NUMERO_DE_CONTA_POUPANCA++;
            return NUMERO_DE_CONTA_POUPANCA;
        }
    }

    private Conta setCC(Long id, Agencia agencia, int numero, Cliente cliente) {
        return conta = new ContaCorrente(id, agencia, numero, cliente);
    }

    private Conta setCP(Long id, Agencia agencia, int numero, Cliente cliente) {
        return conta = new ContaPoupanca(id, agencia, numero, cliente);
    }
    
    private void imprimeExtrato() {
        conta.imprimirExtrato();
    }
}
