package com.treinamento.oo.bancodigitaljava.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.oo.bancodigitaljava.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Page<Cliente> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Cliente> findByCpfContainingIgnoreCase(String cpf, Pageable pageable);
    List<Cliente> findByNome(String nome);
}