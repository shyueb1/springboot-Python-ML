package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UserP {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String location;
    private String signUpAge;
    private String signUpDate;

    public UserP(long id, String userName, String firstName, String lastName, String email, String password, String location, String signUpAge, String signUpDate) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.location = location;
        this.signUpAge = signUpAge;
        this.signUpDate = signUpDate;
    }

    public UserP() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserP userP = (UserP) o;
        return id == userP.id &&
                userName.equals(userP.userName) &&
                firstName.equals(userP.firstName) &&
                lastName.equals(userP.lastName) &&
                email.equals(userP.email) &&
                password.equals(userP.password) &&
                location.equals(userP.location) &&
                signUpAge.equals(userP.signUpAge) &&
                signUpDate.equals(userP.signUpDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstName, lastName, email, password, location, signUpAge, signUpDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", signUpAge='" + signUpAge + '\'' +
                ", signUpDate='" + signUpDate + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSignUpAge() {
        return signUpAge;
    }

    public void setSignUpAge(String signUpAge) {
        this.signUpAge = signUpAge;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }


}
