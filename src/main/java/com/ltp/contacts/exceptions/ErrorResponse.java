package com.ltp.contacts.exceptions;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    private String massage;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;




    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String massage) {
        this.timestamp = LocalDateTime.now();
        this.massage = massage;
    }

    public String getMassage() {
        return this.massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }


    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


   
}
