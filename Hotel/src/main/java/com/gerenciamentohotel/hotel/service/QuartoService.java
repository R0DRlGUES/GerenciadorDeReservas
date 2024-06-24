package com.gerenciamentohotel.hotel.service;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {


    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }
    public List<Quarto> getAll(){return this.quartoRepository.findAll();}
    public Quarto save(Quarto quartos){return  this.quartoRepository.save(quartos);}
    public List<Quarto> getById(int id){return  this.quartoRepository.findById(id);}
    public String validarNome(String nome) {
        Quarto quartos = quartoRepository.findByNome(nome);
        if (quartos != null) {
            return "Quarto já cadastrado!";
        }
        return null;
    }

    public List<Quarto> findByDisponivel() {
        return quartoRepository.findByDisponivel();
    }

    public List<Quarto> findByQtdMaxOcupantes(Integer qtd_max_ocupantes) {
        return quartoRepository.findByQtdMaxOcupantes(qtd_max_ocupantes);
    }

    public List<Quarto> findByDisponivelAndVistaMar(String status, boolean vistaMar) {
        return quartoRepository.findByDisponivelAndVistaMar(status, vistaMar);
    }

}
