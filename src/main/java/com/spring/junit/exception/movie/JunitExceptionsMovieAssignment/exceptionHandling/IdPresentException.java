package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.exceptionHandling;

public class IdPresentException extends Exception{

    private String errorMessage;


    public IdPresentException(){}

    public IdPresentException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
