package com.seyf.movie.service;

import com.seyf.movie.configuration.OmdbConfiguration;
import com.seyf.movie.model.dto.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OmdbApiService {

    private RestTemplate restTemplate;

    private OmdbConfiguration omdbConfiguration;

    public OmdbApiService(RestTemplate restTemplate, OmdbConfiguration omdbConfiguration) {
        this.restTemplate = restTemplate;
        this.omdbConfiguration = omdbConfiguration;
    }

    public SearchResponse getContent(String term) {

        SearchResponse searchResponse = null;

        try {
            String url = omdbConfiguration.getUrl() + "?s={term}&apikey={apiKey}";
            searchResponse = restTemplate.getForObject(url, SearchResponse.class, term, omdbConfiguration.getApiKey());
        } catch (RestClientException ex) {
            log.error("omdb client error: ", ex.getMessage());
            ex.printStackTrace();
        }

        return searchResponse;
    }

    /*
        // To add custom request headers to HTTP GET request, you should use the generic exchange() method provided by the RestTemplate class.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<SearchResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, SearchResponse.class, term, omdbConfiguration.getApiKey());
        if (response.getStatusCode() == HttpStatus.OK)
            searchResponse = response.getBody();
   */
}
