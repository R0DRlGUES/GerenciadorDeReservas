package com.gerenciamentohotel.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeWebController {


    @GetMapping("/cadastrar/hospede")
    public String abrirCadastroHospede(){return "redirect:/hospede";}

    @PostMapping("/cadastrar/quarto")
    public String abrirCadastroQuarto(){return "redirect:/quarto";}

    @PostMapping("/cadastrar/reserva")
    public String abrirCadastroReserva(){return "redirect:/reserva";}

    @PostMapping("/consultaQuarto")
    public String abrirConsultaQuarto(){return "redirect:/consultaQuarto";}
}
