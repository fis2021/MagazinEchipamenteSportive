package org.loose.fis.registration.example.exceptions;

public class UserAlreadyExistsException extends Exception {

    private String username;

    public UserAlreadyExistsException(String username) {
        super(String.format("An account with the username %s already exists!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
