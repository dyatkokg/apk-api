package me.dyatkokg.apkapi.exception;

public class FileWithNameAndVersionAlreadyExistException extends RuntimeException{

    public FileWithNameAndVersionAlreadyExistException(){
        super("File with this name and version already exist");
    }
}
