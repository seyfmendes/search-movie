package com.seyf.movie.controller;

import com.seyf.movie.model.entity.MovieInfo;
import com.seyf.movie.service.SearchService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Search Movie", description = "Search For Movie in Omdb Api")
@RestController
@RequestMapping(path = "search")
@CrossOrigin(origins = "*")
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ApiOperation(value = "Search For Movie")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "It is successful"),
            @ApiResponse(code = 404, message = "movie not found"),
            @ApiResponse(code = 500, message = "It is failed"),
    })
    @RequestMapping(method = RequestMethod.GET, value = "{term}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieInfo> search(@ApiParam(value = "search for term", required = true) @PathVariable String term) {
        return searchService.search(term);
    }
}
