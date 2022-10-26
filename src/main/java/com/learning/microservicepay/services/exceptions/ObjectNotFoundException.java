package com.learning.microservicepay.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException() { super("Usuario não encontrado");
    }
}
