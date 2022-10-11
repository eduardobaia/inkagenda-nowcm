package com.example.inkagenda.service;

import com.example.inkagenda.dto.AgendaDto;
import com.example.inkagenda.exceptions.BadRequestException;
import com.example.inkagenda.model.Agenda;
import com.example.inkagenda.repository.AgendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgendaService {

    private AgendaRepository agendaRepository;

    public void save(AgendaDto agenda){
            agendaRepository.save(mapToAgenda(agenda));
    }

    public void update(AgendaDto agenda){
            agendaRepository.save(mapToAgenda(agenda));
    }

    public void delete (long id){
        agendaRepository.delete(mapToAgenda(findByid(id)));
    }


    public List<AgendaDto> findAlll(){
       return agendaRepository.findAll()
               .stream()
               .map( agenda -> mapToDto(agenda))
               .collect(Collectors.toList());

    }


    public AgendaDto findByid(Long id){
        Agenda agenda = agendaRepository.findById(id)
                .orElseThrow( ()-> new BadRequestException("Agenda not found"));
        return mapToDto(agenda);

    }
    private static Agenda mapToAgenda(AgendaDto agendaDto){
        return new Agenda().builder()
                .name(agendaDto.getName())
                .descritpion(agendaDto.getDescritpion())
                .user(agendaDto.getUser())
                .funcionalities(agendaDto.getFuncionalies())
                .build();

    }

    private static AgendaDto mapToDto(Agenda agenda){
        return new AgendaDto().builder()
                .id(agenda.getId())
                .name(agenda.getName())
                .descritpion(agenda.getDescritpion())
                .user(agenda.getUser())
                .schedules(agenda.getSchedules())
                .funcionalies(agenda.getFuncionalities())
                .build();

    }
}
