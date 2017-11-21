package com.electricity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Format of duration is wrong.")
public class InvalidFormatException extends RuntimeException
{

    private static final long serialVersionUID = 1L;


    public InvalidFormatException(String message)
    {
        super(message);
    }
}
