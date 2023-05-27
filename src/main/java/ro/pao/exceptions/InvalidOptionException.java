package ro.pao.exceptions;

public class InvalidOptionException extends Exception{
    public InvalidOptionException(String message){
        super(message);
    }

    public InvalidOptionException(){
        super();
    }
}


