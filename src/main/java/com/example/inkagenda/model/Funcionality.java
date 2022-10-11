package com.example.inkagenda.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Funcionality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    private String description;
    private String duration;
    private String color;
    private boolean isActive;
    private BigDecimal price;

    @ManyToOne(fetch = LAZY)
    private Agenda agenda;

}
