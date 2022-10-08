package com.treinamento.oo.bancodigitaljava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.oo.bancodigitaljava.entities.Cliente;
import com.treinamento.oo.bancodigitaljava.entities.Conta;
import com.treinamento.oo.bancodigitaljava.services.BancoService;

@RestController
public class BancoController {
    
    private BancoService bancoService;
    
    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping(value = "/abrirConta")
    public ResponseEntity<String> abrirConta(String nome, String cpf, String celular, String tipoConta, String agencia) {
        System.out.println(nome + cpf + celular + tipoConta + agencia);
		return bancoService.abreConta(nome, cpf, celular, tipoConta, agencia);
    }
    
    @GetMapping(value = "/listar-contas")
    public ResponseEntity<Page<Conta>> listarContas(Pageable pageable) {
        return bancoService.listarContas(pageable);
    }
    
    @GetMapping(value = "/listar-clientes")
    public ResponseEntity<Page<Cliente>> listarClientes(Pageable pageable) {
        return bancoService.listarClientes(pageable);
    }

    @GetMapping(value = "/listar-contas-por-cpf")
    public ResponseEntity<List<Conta>> listarContasPorCpf(
        @RequestParam(defaultValue = "") String cpf, Pageable pageable) {
        return bancoService.listarContasPorCpf(cpf, pageable);
    }   
        
    @GetMapping(value = "/listar-clientes-por-nome")
    public ResponseEntity<Page<Cliente>> mostrarClientesPorNome(
        @RequestParam(defaultValue = "") String nome, Pageable pageable) {
        return bancoService.mostrarClientesPorNome(nome, pageable);
    }
            
    @GetMapping(value = "/mostrar-cliente-por-cpf")
    public ResponseEntity<Optional<Cliente>> mostrarClientesPorCpf(
        @RequestParam(defaultValue = "") String cpf) {
        return bancoService.mostrarClientePorCpf(cpf);
    }
                
    @GetMapping(value = "/extrato/{numeroConta}")
    public String imprimirExtrato(@PathVariable int numeroConta) {
        return bancoService.imprimirExtrato(numeroConta);
    }
                
    @PostMapping(value = "/depositar/{numeroConta}/{valorDeposito}")
    public String depositar(@PathVariable int numeroConta, @PathVariable Long valorDeposito) {
        return bancoService.depositar(numeroConta, valorDeposito);
    }

    @GetMapping(value = "/transferir/{numeroContaDebitar}/{numeroContaDepositar}/{valorTransferir}")
    public String transferir(@PathVariable int numeroContaDebitar, @PathVariable int numeroContaDepositar, @PathVariable Long valorTransferir) {
        return bancoService.transferir(numeroContaDebitar, numeroContaDepositar, valorTransferir);
    }

}
