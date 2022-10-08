package com.treinamento.oo.bancodigitaljava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.treinamento.oo.bancodigitaljava.services.ContaService;

@RestController
public class ContaController {
    
    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    
}
