package com.seyf.movie.service;

import com.seyf.movie.model.dto.SearchResponse;
import com.seyf.movie.model.entity.MovieInfo;
import com.seyf.movie.utils.ModelMapperUtils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchService {

    private MovieService movieService;

    private OmdbApiService omdbApiService;

    public SearchService(MovieService movieService, OmdbApiService omdbApiService) {
        this.movieService = movieService;
        this.omdbApiService = omdbApiService;
    }

    @Cacheable(value = "movies", key = "#term")
    public List<MovieInfo> search(String term) {
        List<MovieInfo> movieInfos = movieService.searchByTitle(term.toUpperCase());
        if (movieInfos.isEmpty()) {
            SearchResponse searchResponse = searchInOmdbApi(term);
            movieInfos = mapping(searchResponse);
            saveMovie(movieInfos);
        }
        return movieInfos;
    }

    @Async
    public void saveMovie(List<MovieInfo> movies) {
        if (movies != null && !movies.isEmpty())
            movies.stream().forEach(movie -> movieService.save(movie));
    }

    private List<MovieInfo> mapping(SearchResponse searchResponse) {
        List<MovieInfo> movieInfos = null;
        if (searchResponse.isResponse())
            movieInfos = ModelMapperUtils.mapAll(searchResponse.getSearch(), MovieInfo.class);
        return movieInfos;
    }

    private SearchResponse searchInOmdbApi(String term) {
        return omdbApiService.getContent(term);
    }
}
