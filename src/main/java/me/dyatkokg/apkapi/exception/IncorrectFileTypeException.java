package me.dyatkokg.apkapi.exception;

public class IncorrectFileTypeException extends RuntimeException {

    public IncorrectFileTypeException() {
        super("Data being loaded is of the wrong type");
    }

}
