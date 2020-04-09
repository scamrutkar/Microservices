package com.javacase.sagar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Authentication {

    private String userName;
    private String password;
}
