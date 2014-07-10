package com.rhcloud.gmn.tm.api.entity;

/**
 * @author niaz
 */

public class UserDetails {

    public static final String USER_GET = "user.get";

    private String u_id;

    private String firstName;
    private String lastName;
    private String email;

    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" + u_id + "," + firstName + " " + lastName + "," + email + "}";
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

}
