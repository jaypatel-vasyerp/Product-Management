package com.jayptl.learningjpa.exception;

public class EntityNotFoundException extends RuntimeException{
    
    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(){
        
    }

}
