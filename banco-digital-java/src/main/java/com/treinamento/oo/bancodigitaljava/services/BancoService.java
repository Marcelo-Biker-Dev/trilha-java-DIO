package com.treinamento.oo.bancodigitaljava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.treinamento.oo.bancodigitaljava.entities.Cliente;
import com.treinamento.oo.bancodigitaljava.entities.Conta;
import com.treinamento.oo.bancodigitaljava.entities.ContaCorrente;
import com.treinamento.oo.bancodigitaljava.entities.ContaPoupanca;
import com.treinamento.oo.bancodigitaljava.enums.Agencia;
import com.treinamento.oo.bancodigitaljava.enums.TipoDeConta;
import com.treinamento.oo.bancodigitaljava.repositories.ClienteContasRepository;
import com.treinamento.oo.bancodigitaljava.repositories.ClienteRepository;
import com.treinamento.oo.bancodigitaljava.repositories.ContaRepository;

@Service
public class BancoService {

    private Conta novaConta;
    private Cliente cliente;

    @Autowired
    private ClienteRepository repoCliente;
    
    @Autowired
    private ContaRepository repoConta;

    @Autowired
    private ClienteContasRepository repoClienteContas;

    Agencia agencia;
    
    Scanner sc = new Scanner(System.in);

    public ResponseEntity<String> abreConta(String nome, String cpf, String celular, String tipoConta, String agenciaEscolhida) {
        
        cliente = new Cliente(cpf, nome, celular);
        repoCliente.save(cliente);
        System.out.println("(!!! ATENÇÃO !!!) Cliente nome é " + cliente.getNome() + " cpf é " + cliente.getCpf() + "e a resposta a seguir deve ser o nome, e vem do ClienteRepository: " +repoCliente.findById(cliente.getCpf()));

        for (Agencia ag : Agencia.values()) {
            if (ag.toString().equalsIgnoreCase(agenciaEscolhida)) {
                agencia = ag;
            } 
        }
        
        if (TipoDeConta.CC.toString().equalsIgnoreCase(tipoConta)) {
            System.out.println(" (1ª linha) A agencia escolhida é a " + agencia + " e o tipo de conta escolhido é " + tipoConta);
            novaConta = new ContaCorrente(cliente, agencia);
            System.out.println("(ANTES DO repoConta SAVE) -->  número da conta: " + novaConta.getNumeroDeConta());
            repoConta.save(novaConta);
            System.out.println("(DEPOIS DO repoConta SAVE) -->  número da conta: " + novaConta.getNumeroDeConta());
        }
        else if (TipoDeConta.POUPANCA.toString().equalsIgnoreCase(tipoConta)) {
            System.out.println(" (1ª linha) A agencia escolhida é a " + agencia + " e o tipo de conta escolhido é " + tipoConta);
            novaConta = new ContaPoupanca(cliente, agencia);
            System.out.println("(ANTES DO repoConta SAVE) -->  número da conta: "+novaConta.getNumeroDeConta());
            repoConta.save(novaConta);
            System.out.println("(DEPOIS DO repoConta SAVE) -->  número da conta: "+novaConta.getNumeroDeConta());
        }
        
        for (Conta c : cliente.getContas()) {
            System.out.println("imprimindo as contas do cliente " + c.getNumeroDeConta() );
        }
        cliente.adicionaConta(novaConta);
        return new ResponseEntity<String>("Conta criada com sucesso", HttpStatus.CREATED);
    }

    
    public ResponseEntity<Page<Conta>> listarContas(Pageable pageable) {
        Page<Conta> result = repoConta.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    
    public ResponseEntity<Page<Cliente>> listarClientes(Pageable pageable) {
        Page<Cliente> result = repoCliente.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    
    /*public ResponseEntity<List<Conta>> listarContasPorCpf(String cpf, Pageable pageable) {
        List<Conta> list = new ArrayList<Conta>();
        Page<Conta> result = repoConta.findAll(pageable);
        int count = 0;
        for (Conta c : result) {
            if (c.getClienteCpf().equals(cpf)) {
                list.add(c);
                count++;
            }    
        }
        if (count > 0) {
            return ResponseEntity.ok(list);
        }
        else return ResponseEntity.badRequest().build();
    }*/
    
    public ResponseEntity<List<Conta>> listarContasPorCpf(String cpf, Pageable pageable) {
        Optional<Cliente> esteCliente = repoCliente.findById(cpf);
        List<Conta> list = esteCliente.get().getContas();
        System.out.println("NOME DESTE CLIENTE: " + esteCliente.get().getNome() + ". Tem " + list.size() + " contas");
        if (list.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else return ResponseEntity.ok(list);
    }


    public ResponseEntity<Page<Cliente>> mostrarClientesPorNome(String nome, Pageable pageable) {
        return repoCliente.findByNomeContainingIgnoreCase(nome, pageable)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Cliente> mostrarClientePorCpf(String cpf) {
        return repoCliente.findById(cpf)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }
    

    public String imprimirExtrato(int numeroConta) {
        String extrato = "";
        List<Conta> contas = repoConta.findAll();
        for (Conta conta : contas) {
            if (conta.getNumeroDeConta() == numeroConta) {
                extrato = conta.imprimirExtrato();
            }
        }
        return extrato;
    }


    public String depositar(int numeroConta, Long valorDeposito) {
        List<Conta> contas = repoConta.findAll();
        for (Conta conta : contas) {
            if (conta.getNumeroDeConta() == numeroConta) {
                conta.depositar(valorDeposito);
                repoConta.save(conta);
                return "Depósito efetuado com sucesso";
            }
        }
        return "Conta não encontrada. Por favor verifique o número informado";
    }


    public String transferir(int numeroContaDebitar, int numeroContaDepositar, Long valorTransferir) {
        List<Conta> contas = repoConta.findAll();
        for (Conta contaDeb : contas) {
            if (contaDeb.getNumeroDeConta() == numeroContaDebitar) {
                for (Conta contaDep : contas) {
                    System.out.println(numeroContaDebitar+ " " + contaDeb.getNumeroDeConta()+ " " + numeroContaDepositar+ " " + contaDep.getNumeroDeConta());
                    if (contaDep.getNumeroDeConta() == numeroContaDepositar) {
                        contaDeb.sacar(valorTransferir);
                        repoConta.save(contaDeb);
                        contaDep.depositar(valorTransferir);
                        repoConta.save(contaDep);
                        return "Transferência efetuada com sucesso";
                    }
                }
                return "Conta de destino não encontrada. Por favor verifique o número informado";
            }
        }
        return "Conta de origem não encontrada. Por favor verifique o número informado";
    }
}
