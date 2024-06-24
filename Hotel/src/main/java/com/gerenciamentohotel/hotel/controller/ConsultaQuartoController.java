package com.gerenciamentohotel.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConsultaQuartoController {

    @PostMapping("/retornarConsultaHome")
    public String retornar() {
        return "redirect:/home";
    }

    @PostMapping("/consultaQuarto/consultaQuartosDisponiveis")
    public String abrirCadastroHospede() {
        return "redirect:/consultaQuartosDisponiveis";
    }

    @PostMapping("/consultaQuarto/consultaQuartosOcupantes")
    public String abrirCadastroOcupantes(@RequestParam("qtdOcupantes") int qtdOcupantes) {
        return "redirect:/consultaQuartosOcupantes?qtdOcupantes=" + qtdOcupantes;
    }

    @PostMapping("/consultaQuarto/consultaQuartosVistaMar")
    public String abrirCadastroOcupantes(@RequestParam("status") String status,@RequestParam("vista_mar") boolean vista_mar) {
        status = "Vago";
        vista_mar = true;
        return "redirect:/consultaQuartosOcupantes?qtdOcupantes=" + status +vista_mar;
    }
    @GetMapping("/consultarQuartos")
    public String consultarQuartos(Model model) {
        return "consultaQuarto";
    }
}
