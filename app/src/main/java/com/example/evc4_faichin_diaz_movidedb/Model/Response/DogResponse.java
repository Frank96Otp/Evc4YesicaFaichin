package com.example.evc4_faichin_diaz_movidedb.Model.Response;

import java.util.List;

public class DogResponse {

    private List<String> message;
    private String status;





    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
