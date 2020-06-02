package com.seyf.movie.model.entity;


import com.seyf.movie.enums.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "User information")
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @ApiModelProperty(required = true, notes = "id of user")
    private Long id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @Column(name = "user_name", unique = true)
    @ApiModelProperty(required = true, notes = "user name")
    private String userName;

    @Column(name = "password_hash")
    @ApiModelProperty(required = true, notes = "user password")
    private String password;

    @Column(name = "name")
    @ApiModelProperty(required = true, notes = "name")
    private String name;

    @Column(name = "surname")
    @ApiModelProperty(required = true, notes = "surname")
    private String surname;

    @Column(name = "email")
    @ApiModelProperty(required = true, notes = "surname")
    private String email;


}
