package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ConsultaQuartoController {

    private final QuartoService quartoService;

    public ConsultaQuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping("/consultaQuarto/retornar")
    public String retornar() {
        return "redirect:/home";
    }

    @GetMapping("/consultarQuartos")
    public String consultarQuartos(Model model) {
        return "consultaQuarto";
    }


}
