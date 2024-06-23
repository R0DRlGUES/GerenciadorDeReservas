package com.gerenciamentohotel.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date data_entrada;
    @Temporal(TemporalType.DATE)
    private Date data_saida;

    private String status;
    private BigDecimal valor_total;

    @OneToOne
    @JoinColumn(name = "pkQuarto")
    private Quarto quarto;

    @OneToOne
    @JoinColumn(name = "pkHospede")
    private Hospede hospede;

}