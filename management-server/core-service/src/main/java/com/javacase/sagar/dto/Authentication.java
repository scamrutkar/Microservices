package com.javacase.sagar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "AUTHENTICATION_INFO")
public class Authentication implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "authentication_id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "interface")
    private String type ;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="device_id")
    private Device device;

}
