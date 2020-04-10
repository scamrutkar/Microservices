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
@Table(name = "SNMP_INFO")
public class SnmpInfo {

    @Id
    @GeneratedValue
    @Column(name = "snmp_id")
    private Long id;
    @Column(name = "snmp_v2_community")
    private String snmpV2Community;
    @Column(name = "snmp_user_name")
    private String snmpUserName;
    @Column(name = "snmp_user_password")
    private String snmpPassword;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

}
