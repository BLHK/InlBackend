package se.sero.project.service.exceptions;

public final class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message) {
        super(message);
    }
}
