package com.seyf.movie.service;


import com.seyf.movie.model.entity.MovieInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTests {

    private String term = "movie";
    private String sameTerm = "movie";
    private String differentTerm = "king";
    private List<MovieInfo> movieInfos;

    @Autowired
    private SearchService searchService;

    @Before
    public void init() {
        movieInfos = searchService.search(term);
    }

    @Test
    public void Should_CheckObject_When_EnterSameTerm() {
        List<MovieInfo> movies = searchService.search(sameTerm);
        assertThat(movieInfos).isEqualTo(movies);
    }

    @Test
    public void Should_CheckSize_When_EnterSameTerm() {
        List<MovieInfo> movies = searchService.search(sameTerm);
        assertThat(movieInfos.size()).isEqualTo(movies.size());
    }

    @Test
    public void Should_CheckObject_When_DifferentTerm() {
        List<MovieInfo> movies = searchService.search(differentTerm);
        assertThat(movieInfos).isNotEqualTo(movies);
    }

    @Test
    public void Should_CheckTitle_When_EnterDifferentTerm() {
        List<MovieInfo> movies = searchService.search(differentTerm);
        assertThat(movieInfos.get(0).getTitle()).isNotEqualTo(movies.get(0).getTitle());
    }

}

