package tech.immo.maintenance.exceptions;

public class UserNotFoundException  extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
