package com.seyf.movie.configuration;


import com.seyf.movie.MovieApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MovieApplication.class})
public class OmdbConfigurationTests {

    @Autowired
    OmdbConfiguration omdbConfiguration;

    @Test
    public void Should_Check_OmdbConfiguration() {
        Assert.assertEquals(omdbConfiguration.getUrl(), "http://www.omdbapi.com/");
        Assert.assertEquals(omdbConfiguration.getApiKey(), "73527106");
    }
}
