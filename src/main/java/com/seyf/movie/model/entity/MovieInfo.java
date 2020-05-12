package com.seyf.movie.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(description = "All details about the Movie")
@Data
@Entity
@Table(name = "movie_info")
public class MovieInfo implements Serializable {

    @Id
    @ApiModelProperty(required = true, notes = "id of movie")
    String id;
    @ApiModelProperty(required = true, notes = "title of movie")
    String title;
    @ApiModelProperty(required = true, notes = "year of movie")
    String year;
    @ApiModelProperty(required = true, notes = "type of movie")
    String type;
    @ApiModelProperty(value = "poster of movie")
    String poster;

}
