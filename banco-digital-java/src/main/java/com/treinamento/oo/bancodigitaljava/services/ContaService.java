package com.treinamento.oo.bancodigitaljava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.oo.bancodigitaljava.repositories.ContaRepository;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository repoConta;

    

}
