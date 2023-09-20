package com.ltp.contacts.exceptions;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;




    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String massage) {
        this.timestamp = LocalDateTime.now();
        this.message = massage;
    }

    public String getMassage() {
        return this.message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }


    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


   
}
