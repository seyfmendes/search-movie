package com.seyf.movie.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse implements Serializable {
    @JsonProperty("Search")
    private List<MovieResponse> search = new ArrayList<>();
    private int totalResults;
    @JsonProperty("Response")
    private boolean response;

    public List<MovieResponse> getSearch() {
        return search;
    }

    public void setSearch(List<MovieResponse> search) {
        this.search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
