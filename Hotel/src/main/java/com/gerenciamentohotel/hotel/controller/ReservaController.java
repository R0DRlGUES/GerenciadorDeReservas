package com.gerenciamentohotel.hotel.controller;

import com.gerenciamentohotel.hotel.model.Hospede;
import com.gerenciamentohotel.hotel.model.Quarto;
import com.gerenciamentohotel.hotel.model.Reserva;
import com.gerenciamentohotel.hotel.service.HospedeService;
import com.gerenciamentohotel.hotel.service.QuartoService;
import com.gerenciamentohotel.hotel.service.ReservaService;
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
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    @Autowired
    private HospedeService hospedeService;

    @Autowired
    private QuartoService quartoService;


    @PostMapping("/reserva/retornar")
    public String retornar(){return "redirect:/home";}

    @GetMapping(path = "/reserva")
    public String getAllReserva(Model model){
        List<Reserva> reservas = reservaService.getAll();
        model.addAttribute("reserva", reservas);

        List<Hospede>hospedes = hospedeService.getAll();
        model.addAttribute("hospedes",hospedes);

        List<Quarto>quartos = quartoService.getAll();
        model.addAttribute("quartos",quartos);
        return "reserva";
    }

    @PostMapping("reserva/save")
    public String saveReserva(Reserva reserva, @RequestParam("dataEntrada") String dataEntradaStr,@RequestParam("dataSaida") String dataSaidaStr )  throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataEntrada = format.parse(dataEntradaStr);
        Date dataSaida = format.parse(dataSaidaStr);

        reserva.setData_entrada(dataEntrada);
        reserva.setData_saida(dataSaida);

        reservaService.save(reserva);
        //reserva.setDataEntrada(dataHoraEntrada);
        //reserva.setDataSaida(dataHoraSaida);


        return "redirect:/reserva";
    }

}
