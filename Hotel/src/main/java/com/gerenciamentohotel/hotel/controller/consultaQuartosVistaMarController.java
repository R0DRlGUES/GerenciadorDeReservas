package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class consultaQuartosVistaMarController {

    private final QuartoService quartoService;

    public consultaQuartosVistaMarController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping(path = "/consultaQuartosVistaMar")
    public String getAllHospedes(Model model) {
        String status = "Vago";
        List<Quarto> quartos = quartoService.findByDisponivelAndVistaMar(status,true);
        model.addAttribute("quartos", quartos);
        return "consultaQuartosVistaMar";
    }

    @PostMapping("/retornarConsultaVistaMarHome")
    public String retornar() {
        return "redirect:/home";
    }
}
