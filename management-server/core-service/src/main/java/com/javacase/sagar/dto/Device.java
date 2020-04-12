package com.javacase.sagar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "DEVICE_INFO")
public class Device implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Long id;
    @Column(name = "device_unique_id")
    private String deviceId;
    @Column(name = "device_name")
    private String deviceName;
    @Column(name = "serial_id")
    private String serialId;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "host_name")
    private String hostName;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "device_type")
    private String deviceType;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<Authentication> authentication;
    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL)
    private SnmpInfo snmp;
    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL)
    private AwsInfo aws;

    public void addAuthentication(Authentication auth) {
        this.authentication.add(auth);
        auth.setDevice(this);
    }

    public Device updateAuthenticationDeviceId() {
        this.getAuthentication()
                .forEach(authentication -> authentication.setDevice(this));
        return this;
    }

    public Device updateAwsDeviceId() {
        this.getAws().setDevice(this);
        return this;
    }

    public Device updateSnmpDeviceId() {
        this.getSnmp().setDevice(this);
        return this;
    }

}
