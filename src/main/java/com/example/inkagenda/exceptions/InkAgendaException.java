package com.example.inkagenda.exceptions;

public class InkAgendaException extends RuntimeException {
    public InkAgendaException(String exMessage, Exception exception) {
        super(exMessage,exception);
    }

    public InkAgendaException(String exMessage) {
        super(exMessage);
    }
}
