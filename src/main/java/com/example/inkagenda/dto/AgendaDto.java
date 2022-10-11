package com.example.inkagenda.dto;

import com.example.inkagenda.model.Funcionality;
import com.example.inkagenda.model.Schedule;
import com.example.inkagenda.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaDto {
    private  Long id;
    private User user;
    private String name;
    private String descritpion;

    private List<Funcionality> funcionalies;
    private List<Schedule> schedules;
    private LocalDate dateIni;
    private LocalDate dateEnd;
    private Instant createdDate;

}
