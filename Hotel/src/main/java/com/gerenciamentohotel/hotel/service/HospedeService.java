package com.gerenciamentohotel.hotel.service;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.repository.HospedeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class HospedeService {

    private final HospedeRepository hospedeRepository;

    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }
    public List<Hospede> getAll() {
        return this.hospedeRepository.findAll();
    }

    public Hospede save(Hospede hospede) {
        return this.hospedeRepository.save(hospede);
    }

    public String validarNomeDisponivel(String nome) {
        Hospede hospede = hospedeRepository.findByNome(nome);
        if (hospede != null) {
            return "Nome já em uso, tente outro!";
        }
        return null;
    }

        public boolean validarIdade(Hospede hospede) {
            boolean returnOK = false;

            Date dataNascimento = hospede.getData_nascimento();
            LocalDate dataNascimentoLocalDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dataAtual = LocalDate.now();
            Period periodo = Period.between(dataNascimentoLocalDate, dataAtual);

            int idade = periodo.getYears();

            if (idade >= 18) {
                returnOK = true;
            } else {
                return returnOK;
            }
            return returnOK;
        }
    }
