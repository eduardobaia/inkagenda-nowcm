package com.example.inkagenda;

import com.example.inkagenda.conf.SwaggerConfiguration;
import com.example.inkagenda.controller.AgendaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class InkAgendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkAgendaApplication.class, args);

    }

}
