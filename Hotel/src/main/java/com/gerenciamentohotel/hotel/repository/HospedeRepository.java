package com.gerenciamentohotel.hotel.repository;

import com.gerenciamentohotel.hotel.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    Hospede findByNome(String nome);
}



