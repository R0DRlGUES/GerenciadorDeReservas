package com.gerenciamentohotel.hotel.repository;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Long>{
    List<Quarto> findById(Integer id);

    @Query("SELECT q FROM Quarto q WHERE q.status = 'Aberto'")
    List<Quarto> findByDisponivel();

    @Query("SELECT q FROM Quarto q WHERE q.qtd_max_ocupantes = :qtdMaxOcupantes")
    List<Quarto> findByQtdMaxOcupantes(Integer qtdMaxOcupantes);

    @Query("SELECT q FROM Quarto q WHERE q.status = 'Aberto' and q.vista_mar = true")
    List<Quarto> findByDisponivelAndVistaMar(String status, boolean vistaMar );

    Quarto findByNome(String nome);


}
