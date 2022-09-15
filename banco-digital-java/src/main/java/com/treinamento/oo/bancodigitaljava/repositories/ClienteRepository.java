package com.treinamento.oo.bancodigitaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.oo.bancodigitaljava.entities.Client;

public interface ClienteRepository extends JpaRepository<Client, Long>{
    
}
