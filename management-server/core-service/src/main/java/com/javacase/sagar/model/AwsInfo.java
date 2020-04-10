package com.javacase.sagar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "AWS_INFO")
public class AwsInfo {

    @Id
    @GeneratedValue
    @Column(name = "aws_id")
    private Long id;
    @Column(name = "aws_secret_key")
    private String awsSecretKey;
    @Column(name = "aws_access_key")
    private String awsAccessKey;
    @Column(name = "aws_region")
    private String awsRegion;
    @Column(name = "aws_vpc_id")
    private String awsVpcId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

}
