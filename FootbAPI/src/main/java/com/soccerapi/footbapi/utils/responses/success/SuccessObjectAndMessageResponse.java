package com.soccerapi.footbapi.utils.responses.success;

import com.soccerapi.footbapi.utils.responses.BaseMessage;

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
