package Exceptions;

import java.io.IOException;

public class UnidentifiedKeyException extends RuntimeException{
    public UnidentifiedKeyException(){
        System.out.println("Key doesn't exist");
    }
}
