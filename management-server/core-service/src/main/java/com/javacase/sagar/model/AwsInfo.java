package com.javacase.sagar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;


public class AwsInfo {

    private String awsSecretKey;
    private String awsAccessKey;
    private String awsRegion;
    private String awsVpcId;

}
