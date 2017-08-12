package com.worldticket.recruitment.controller;

import com.worldticket.recruitment.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public abstract class AbstractController {

    public ResponseEntity returnError(HttpStatus status, String message){

        ErrorResponse error = new ErrorResponse();
        error.message = message;
        error.errorCode = status.value();

        return ResponseEntity.status(status).body(error);
    }
}
