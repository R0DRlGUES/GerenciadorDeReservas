package com.gerenciamentohotel.hotel.service;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.model.Reserva;
import com.gerenciamentohotel.hotel.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findByHospede(Hospede hospede){return this.reservaRepository.findByHospede(hospede);}

    public List<Reserva> getAll(){return this.reservaRepository.findAll();}


    public Reserva save(Reserva reserva){return this.reservaRepository.save(reserva);}

    public Optional<Reserva> getById(int id){return  this.reservaRepository.findById(id);}

    public void deleteById(int id){this.reservaRepository.deleteById(id);}
}
