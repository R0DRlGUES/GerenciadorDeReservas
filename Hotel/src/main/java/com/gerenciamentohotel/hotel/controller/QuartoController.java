package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
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
        model.addAttribute("quarto", quartos);
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

    @GetMapping("/buscarTodosDisponiveis")
    public String buscarTodosDisponiveis(Model model) {
        String quartoAux = "Aberto";
        List<Quarto> quartos = quartoService.findByDisponivel(quartoAux);
        model.addAttribute("quarto", quartos);

        return "consultaQuarto";

    }

    @GetMapping("/buscarPorQtdOcupantes")
    public String buscarPorQtdOcupantes(@RequestParam int qtd,Model model) {
        List<Quarto> quartos = quartoService.findByQtdMaxOcupantes(qtd);
        model.addAttribute("quarto", quartos);
        return "redirect:/consultaQuarto";
    }

/*
    @GetMapping("/buscarTodosOcupados")
    public List<String> buscarTodosOcupados(Model model) {
        List<Quarto> quartos = quartoService.fin(qtd);
        model.addAttribute("quarto", quartos);
        return Arrays.asList("Quarto 301", "Quarto 302", "Quarto 303");
    }
*/
    @GetMapping("/buscarTodosComVistaMarEDisponiveis")
    public List<String> buscarTodosComVistaMarEDisponiveis() {
        return Arrays.asList("Quarto 401", "Quarto 402");
    }
}
