package com.kloc.atipera.responses;

public class ErrorResponse implements Response{
    private String status;  //responseCode
    private String message; //whyHasItHappened

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
