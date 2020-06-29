package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class UserP {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String userName;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String location;
    private int signUpAge;
    private Date signUpDate;

    public UserP(long id, String userName, String firstName, String lastName, String email, String password, String location, int signUpAge, Date signUpDate) {
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

    public UserP() {}

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
                signUpAge == userP.signUpAge &&
                signUpDate.equals(userP.signUpDate);
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

    public int getSignUpAge() {
        return signUpAge;
    }

    public void setSignUpAge(int signUpAge) {
        this.signUpAge = signUpAge;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
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

}
