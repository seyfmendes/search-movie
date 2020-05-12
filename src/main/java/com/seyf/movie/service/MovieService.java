package com.seyf.movie.service;


import com.seyf.movie.model.entity.MovieInfo;
import com.seyf.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieInfo save(MovieInfo movieInfo) {
        return movieRepository.save(movieInfo);
    }

    public List<MovieInfo> searchByTitle(String term) {
        return movieRepository.findByTitle(term);
    }
}
