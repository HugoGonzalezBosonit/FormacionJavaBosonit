package com.bosonit.exceptions;
public class UnprocessableEntityException extends Exception {
    public UnprocessableEntityException() {
        super("422(UNPROCESSABLE ENTITY)");
    }

    public UnprocessableEntityException(String mensaje){
        super(mensaje);
    }
}
