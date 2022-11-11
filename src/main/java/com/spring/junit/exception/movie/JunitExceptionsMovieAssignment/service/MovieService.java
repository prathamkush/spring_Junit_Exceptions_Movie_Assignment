package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.service;

import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.Movie;
import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
//        return "{" +
//                "\"message\":"+"\"Successfully added Movie\",\n"+
//                "\"data\":"+savedMovie+",\n"+
//                "}";
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(ObjectId id){
        Optional<Movie> savedMovie = movieRepository.findById(id);

        if(savedMovie.isPresent()) return savedMovie.get();
        return null;

        //        return "{" +
//                "\"message\":"+"\"Successfully fetched movie\",\n"+
//                "\"data\":"+movieRepository.findById(id)+",\n"+
//                "}";
    }


    public Movie updateMovie(Movie movie){
        return movieRepository.save(movie);
//        return "Movie updated successfully";
    }


    public void removeMovie(ObjectId id) {
//        if(movieRepository.existsById(id)) { movieRepository.deleteById(id); return "Delete Successfully!"; }
//        return "Movie NOT FOUND";
        movieRepository.deleteById(id);
    }

}

