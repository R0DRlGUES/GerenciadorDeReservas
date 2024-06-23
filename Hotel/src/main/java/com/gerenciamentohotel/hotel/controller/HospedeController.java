package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HospedeController {

    @GetMapping("/home")
    public String home(){return "home";}

    private final HospedeService hospedeService;

    @Autowired
    public HospedeController(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @PostMapping("/hospede/retornar")
    public String retornar(){return "redirect:/home";}

    @GetMapping(path = "/hospede")
    public String getAllHospedes(Model model){
        List<Hospede> hospedes = hospedeService.getAll();
        model.addAttribute("hospede", hospedes);
        return "hospede";
    }
    @PostMapping(path = "hospede/save")
    public String saveHospede(Hospede hospede, @RequestParam("data") String dataStr, Model model) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = format.parse(dataStr);
        hospede.setData_nascimento(data);
            if (hospedeService.validarIdade(hospede)){
                hospedeService.save(hospede);
                return "redirect:/hospede";
            }else {
                return "redirect:/hospede";
            }
    }

}
