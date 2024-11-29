package com.soccerapi.footbapi.responses;

public abstract class BaseMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseMessage(String message) {
        this.message = message;
    }
}
