package com.example.inkagenda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne()
    private User user;

    @OneToMany(fetch = LAZY)
    private List<Funcionality> funcionalities;

    @OneToMany(fetch = LAZY)
    private List<Schedule> schedules;


    private String name;
    private String descritpion;

    private LocalDate dateIni;
    private LocalDate dateEnd;
    private Instant createdDate;


}
