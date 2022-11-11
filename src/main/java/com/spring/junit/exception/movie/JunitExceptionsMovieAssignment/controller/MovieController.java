package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.controller;

import com.mongodb.MongoIncompatibleDriverException;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.exceptionHandling.IdPresentException;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.exceptionHandling.MovieException;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.Movie;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.PayloadValidation;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movie")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service){
        this.service = service;
    }

    @RequestMapping(value = "/add-movie", method = RequestMethod.POST)
    public Movie saveMovie(@RequestBody Movie payload) throws IdPresentException {

        if(!PayloadValidation.createdPayloadValidation(payload)) throw new IdPresentException("PAYLOAD MALFORMED. OBJECT ID MUST NOT BE DEFINED");

        return service.saveMovie(payload);
    }


    @RequestMapping(value = "/get-movies", method = RequestMethod.GET)
    public List<Movie> getMovies(){
        return service.getMovies();
    }

    @RequestMapping(value = "/get-movie-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") ObjectId id) throws MovieException{

        Movie movie = service.getMovieById(id);
        if(movie==null){
            throw new MovieException("Movie DOESN'T EXISTS");
        }

        return new ResponseEntity<Movie>(service.getMovieById(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/update-movie", method = RequestMethod.PATCH)
    public Movie updateMovie(@RequestBody Movie movie) throws MovieException{

        Movie movieRes = service.getMovieById(movie.getId());
        if(movieRes==null){
            throw new MovieException("Movie DOESN'T EXISTS");
        }

        return service.updateMovie(movie);
    }


    @RequestMapping(value = "/delete-movie/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteMovie(@PathVariable("id") ObjectId id) throws MovieException {

        Movie movie = service.getMovieById(id);
        if(movie==null){
            throw new MovieException("Movie DOESN'T Exists");
        }

        service.removeMovie(id);
        return "{\"message\" : \"Successfully Deleted !!\"}";
    }



}

