
package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model;

import org.bson.types.ObjectId;



public class PayloadValidation {

    public static boolean createdPayloadValidation(Movie movie){


        if(movie.getId()!=null){
            return false;
        }

        return true;
    }


}
