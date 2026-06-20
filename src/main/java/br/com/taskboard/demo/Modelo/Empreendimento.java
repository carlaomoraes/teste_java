package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ideempreendimento;
    private String descempreendimento;
    private LocalDate data_inicio;
    private LocalDate data_fim;}
