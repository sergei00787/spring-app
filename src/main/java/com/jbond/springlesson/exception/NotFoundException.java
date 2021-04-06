package com.jbond.springlesson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super();
    }
    public NotFoundException(String msg)   {
        super(msg);
    }
    public NotFoundException(String msg, Exception e)  {
        super(msg, e);
    }
}
