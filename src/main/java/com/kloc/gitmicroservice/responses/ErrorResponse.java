package com.kloc.gitmicroservice.responses;

import lombok.Getter;
import lombok.Setter;

public record ErrorResponse (
    String status,
    String message
){}
