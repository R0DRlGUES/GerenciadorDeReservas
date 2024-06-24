package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class consultaQuartosOcupantesController {
    private final QuartoService quartoService;
    public consultaQuartosOcupantesController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }
    @GetMapping(path = "/consultaQuartosOcupantes")
    public String getAllHospedes(@RequestParam("qtdOcupantes") int qtdOcupantes, Model model) {
        List<Quarto> quartos = quartoService.findByQtdMaxOcupantes(qtdOcupantes);
        model.addAttribute("quartos", quartos);
        return "consultaQuartosOcupantes";
    }

    @PostMapping("/retornarConsultaOcupantesHome")
    public String retornar() {
        return "redirect:/home";
    }
}
