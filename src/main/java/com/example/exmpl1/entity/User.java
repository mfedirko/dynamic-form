package com.example.exmpl1.entity;

import com.example.exmpl1.entity.audit.Auditable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "usr")
public class User extends Auditable{

    @Column(name = "USR_NM")
    private String username;
    @Column(name = "PASSWD")
    private String passwd;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FIRST_NM")
    private String firstName;
    @Column(name = "LAST_NM")
    private String lastName;

    @Column(name = "ADDR_LINE_1")
    private String addressLine1;
    @Column(name = "ADDR_LINE_2")
    private String addressLine2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PSTL_CD")
    private String postalCode;
    @Column(name = "STATE_PROV")
    private String stateProvince;
    @Column(name = "CNTRY")
    private String country;
    @Column(name = "APT_NO")
    private String aptNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }
}
