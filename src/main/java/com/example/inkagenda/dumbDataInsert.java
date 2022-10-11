package com.example.inkagenda;

import com.example.inkagenda.model.Agenda;
import com.example.inkagenda.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class dumbDataInsert {

    public dumbDataInsert(){

    }
    private static Faker faker = new Faker();

    public static User createUserDumb() {

        User user = new User();


        return user;


    }

    public static Agenda createAgendaDumb(){
        return   Agenda.builder()
                .name(String.valueOf(faker.company().name()))
                .descritpion(String.valueOf(faker.team().name()))
                .user(createUserDumb())
                .build();


    }


    public static void main(String[] args) {
        System.out.println(createAgendaDumb().toString());
    }
}
