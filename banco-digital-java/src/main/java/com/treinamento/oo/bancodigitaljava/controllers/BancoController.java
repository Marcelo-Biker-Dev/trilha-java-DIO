package com.treinamento.oo.bancodigitaljava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.oo.bancodigitaljava.services.BancoService;

@RestController
@RequestMapping(value = "/abrirConta")
public class BancoController {

    @Autowired
    BancoService bancoService;

    @GetMapping
    public void abrirConta() {
        bancoService.abreConta();
    }
    
}
