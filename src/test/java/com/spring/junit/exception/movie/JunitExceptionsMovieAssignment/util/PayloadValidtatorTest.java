package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.util;


import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.Movie;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.PayloadValidation;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayloadValidtatorTest {


    // giving no id (which should not be present)
    @Test
    public void validatePayload(){

        Movie movie = new Movie(null, "MI1", "2002-10-10");

        assertEquals(true, PayloadValidation.createdPayloadValidation(movie));

    }


    //  giving valid id
    @Test
    public void validateInvalidPayload(){
        ObjectId id = new ObjectId("507f191e810c19729de860ea");
        Movie movie = new Movie(id, "MI1", "2002-10-10");

        assertEquals(false, PayloadValidation.createdPayloadValidation(movie));

    }


}
