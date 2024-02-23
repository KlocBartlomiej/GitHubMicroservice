package com.kloc.atipera.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ErrorResponse implements Response{
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String message;

    public ErrorResponse(String status, String message){
        this.status = status;
        this.message = message;
    }
}
