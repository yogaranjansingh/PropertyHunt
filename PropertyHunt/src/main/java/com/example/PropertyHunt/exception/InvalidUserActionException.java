package com.example.PropertyHunt.exception;

public class InvalidUserActionException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InvalidUserActionException(String message)
    {
      this.message = message;
    }
}
