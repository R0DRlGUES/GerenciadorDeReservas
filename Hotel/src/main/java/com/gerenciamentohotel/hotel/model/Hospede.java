package com.gerenciamentohotel.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String telefone;
    private String cpf;
    private String rg;

    @Temporal(TemporalType.DATE)
    private Date data_nascimento;
}

