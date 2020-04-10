package com.javacase.sagar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "DEVICE_INFO")
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "DEVICE_ID")
    private String deviceId;
    @Column(name = "DEVICE_NAME")
    private String deviceName;
    @Column(name = "SERIAL_ID")
    private String serialId;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "HOST_NAME")
    private String hostName;
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    @Column(name = "DEVICE_TYPE")
    private String deviceType;
    @OneToMany(mappedBy = "user")
    private List<Authentication> authentication;
//    private Authentication restInfo;
//    private SnmpInfo snmpInfo;
//    private AwsInfo awsInfo;

}
