package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class consultaQuartosDisponiveisController {


    private final QuartoService quartoService;

    public consultaQuartosDisponiveisController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping(path = "/consultaQuartosDisponiveis")
    public String getAllHospedes(Model model) {
        List<Quarto> quartos = quartoService.findByDisponivel();
        model.addAttribute("quartos", quartos);
        return "consultaQuartosDisponiveis";
    }

    @PostMapping("/retornarConsultaDisponivelHome")
    public String retornar() {
        return "redirect:/home";
    }
}
