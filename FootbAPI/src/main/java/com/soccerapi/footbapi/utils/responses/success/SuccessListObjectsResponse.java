package com.soccerapi.footbapi.utils.responses.success;

import java.util.List;

public class SuccessListObjectsResponse<T> {

    private List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public SuccessListObjectsResponse(List<T> objects) {
        this.objects = objects;
    }
}
