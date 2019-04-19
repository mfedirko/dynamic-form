package com.example.exmpl1.presentation.forms;

import com.example.exmpl1.entity.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.*;

public class RegistrationForm extends BaseForm {

    @Override
    public String[][] fieldLayout(){
        return new String[][]{
                {"emailAddress","username","password"},
                {"firstName","lastName"},
                {"addressLine1","addressLine2","zipCode","aptNumber"},
                {"city","stateProvince","country"},
                {"hasReadTermsAndConditions"}
        };
    }

    public User toUser(){
        User u = new User();
        u.setAddressLine1(addressLine1);
        u.setAddressLine2(addressLine2);
        u.setAptNumber(aptNumber);
        u.setCity(city);
        u.setCountry(country);
        u.setEmail(emailAddress);
        u.setPostalCode(zipCode);
        u.setStateProvince(stateProvince);

        u.setFirstName(firstName);
        u.setLastName(lastName == null ? null : lastName.toString());
        u.setUsername(username);
        u.setPasswd(password);
        return u;

    }

    private static final List<String> REQUIRED_FIELDS = Arrays.asList("emailAddress","username","addressLine1","city","zipCode","stateProvince","country","hasReadTermsAndConditions","password");
    private static final List<String> OPTIONAL_FIELDS = Arrays.asList("firstName","lastName","addressLine2","aptNumber");
    private static final Map<String, FieldDetail> fieldDetailMap = new HashMap<>();
    static {

        for (String field : REQUIRED_FIELDS){
            fieldDetailMap.put(field, new FieldDetail(true,field,"forms.registration." + field));
        }
        for (String field : OPTIONAL_FIELDS){
            fieldDetailMap.put(field, new FieldDetail(false,field,"forms.registration." + field));
        }
        fieldDetailMap.get("hasReadTermsAndConditions").setFieldType(FieldType.CHECKBOX);
        fieldDetailMap.get("zipCode").setFieldType(FieldType.NUMBER);
        fieldDetailMap.get("lastName").setFieldType(FieldType.SELECT_OPTIONS);
        fieldDetailMap.get("password").setFieldType(FieldType.PASSWORD);


    }

    @Pattern(regexp = "^[A-Za-z\\._-]+@[A-Za-z_-]+\\.[A-Za-z_-]+$")
    private String emailAddress;
    private String firstName;
    private FieldType lastName = FieldType.TEXT;
    private String username;

    @Length(min = 10,max = 50)
    private String password;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String aptNumber;
    private String stateProvince;
    private String country;
    private boolean hasReadTermsAndConditions;

    @Override
    public FieldDetail getFieldDetail(String field) {
        return fieldDetailMap.get(field);
    }

    @Override
    public List<String> requiredFields() {
        return REQUIRED_FIELDS;
    }

    @Override
    public List<String> optionalFields() {
        return OPTIONAL_FIELDS;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country='" + country + '\'' +
                ", hasReadTermsAndConditions=" + hasReadTermsAndConditions +
                '}';
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        
    }

    public FieldType getLastName() {
        return lastName;
    }

    public void setLastName(FieldType lastName) {
        this.lastName = lastName;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
        
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

    public boolean isHasReadTermsAndConditions() {
        return hasReadTermsAndConditions;
    }

    public void setHasReadTermsAndConditions(boolean hasReadTermsAndConditions) {
        this.hasReadTermsAndConditions = hasReadTermsAndConditions;
        
    }
}
