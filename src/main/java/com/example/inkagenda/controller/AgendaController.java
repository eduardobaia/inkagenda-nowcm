package com.example.inkagenda.controller;

import com.example.inkagenda.dto.AgendaDto;
import com.example.inkagenda.service.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/agenda")
@AllArgsConstructor
public class AgendaController {

    private AgendaService agendaService;


    @GetMapping
    public ResponseEntity<List<AgendaDto>>  getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.findAlll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDto> findByID(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(agendaService.findByid(id));
    }


    @PostMapping
    public ResponseEntity save (@RequestBody AgendaDto agenda){
        agendaService.save(agenda);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
