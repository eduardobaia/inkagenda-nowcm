package com.example.inkagenda.controller;

import com.example.inkagenda.service.AgendaService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class AgendaControllerTest {

    @InjectMocks
    private AgendaController agendaController;

    @Mock
    private AgendaService agendaService;


}