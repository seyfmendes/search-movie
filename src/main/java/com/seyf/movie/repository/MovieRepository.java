package com.seyf.movie.repository;


import com.seyf.movie.model.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieInfo, String> {

    @Query(name = "Movie.findByTitle", value = "select movie from MovieInfo  movie where upper(movie.title) like %:item% ")
    public List<MovieInfo> findByTitle(String item);
}
