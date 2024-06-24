package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuartoController {
    @Autowired
    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping("/quarto/retornar")
    public String rertornar(){return "redirect:/home";}

    @GetMapping(path = "/quarto")
    public String getAllQuarto(Model model){
        List<Quarto> quartos = quartoService.getAll();
        model.addAttribute("quartos", quartos);
        return "quarto";
    }

    @PostMapping(path = "quarto/save")
    public String saveQuarto(Quarto quarto, Model model){
        String erro = quartoService.validarNome(quarto.getNome());
        if (erro != null){
            model.addAttribute("erro", "Quarto Já Cadastrado!");
            return "redirect:/quarto";
        }else {
            quartoService.save(quarto);
            return "redirect:/quarto";
        }
    }

}
