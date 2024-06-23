package com.gerenciamentohotel.hotel.repository;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByHospede(Hospede hospede);
}
