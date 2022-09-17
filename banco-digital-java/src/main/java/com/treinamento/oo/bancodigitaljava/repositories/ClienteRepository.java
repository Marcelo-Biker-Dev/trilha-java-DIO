package com.treinamento.oo.bancodigitaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.oo.bancodigitaljava.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}