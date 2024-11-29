package com.soccerapi.footbapi.responses.success;

public class SuccessObjectResponse {

    private Object object;

    public SuccessObjectResponse(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
