package org.example.literatualura.Service;

public class RegistroExistenteException extends RuntimeException {

    // Constructor que recibe un mensaje de error
    public RegistroExistenteException(String message) {
        super(message); // Pasa el mensaje al constructor de la clase base (RuntimeException)
    }
}