package com.soccerapi.footbapi.responses.success;

import com.soccerapi.footbapi.responses.BaseMessage;

public class SuccessObjectAndMessageResponse extends BaseMessage {

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public SuccessObjectAndMessageResponse(String message, Object object) {
        super(message);
        this.object = object;
    }
}
