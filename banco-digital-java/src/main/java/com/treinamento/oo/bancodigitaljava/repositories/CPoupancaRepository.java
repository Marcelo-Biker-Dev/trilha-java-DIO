    package com.treinamento.oo.bancodigitaljava.repositories;

    import org.springframework.data.jpa.repository.JpaRepository;
    
    import com.treinamento.oo.bancodigitaljava.entities.Conta;
    
    public interface CPoupancaRepository extends JpaRepository<Conta, Long>{
        
}
