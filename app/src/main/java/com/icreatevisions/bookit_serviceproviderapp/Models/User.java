package com.icreatevisions.bookit_serviceproviderapp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
// This Class is a user object for each service provider to have an account

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class User {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String businessName;
    @NonNull
    private String email;
    @NonNull
    private String password;

    private String address;
    @NonNull


    // Saves the information needed for each user to create an account in our DB

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }





}


