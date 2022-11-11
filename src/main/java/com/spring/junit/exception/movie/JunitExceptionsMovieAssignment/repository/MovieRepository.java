package com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.repository;

import com.spring.junit.exception.movie.JunitExceptionsMovieAssignment.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
