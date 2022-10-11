package com.example.inkagenda.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String location;
    private Date startTime;
    private Date endTime;
    private String categoryColor;

    @ManyToOne(fetch = LAZY)
    private Agenda agenda;

    @ManyToOne(fetch = LAZY)
    private User user;


}
