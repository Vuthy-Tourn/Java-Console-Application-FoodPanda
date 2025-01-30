package model;

import lombok.Data;

@Data

class InvalidInputException extends Exception{
    public InvalidInputException(String message){
        super(message);
    }
}
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
