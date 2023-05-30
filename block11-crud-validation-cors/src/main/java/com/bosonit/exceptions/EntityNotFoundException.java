package com.bosonit.exceptions;


import lombok.Data;


@Data
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("ID NO ENCONTRADO");
    }

    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
