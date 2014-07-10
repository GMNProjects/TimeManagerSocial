package com.rhcloud.gmn.tm.api;

/**
 * Created by niaz on 06.07.2014.
 */
public class TimeManagerProfile {

    private String u_id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public TimeManagerProfile(String u_id, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.u_id = u_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}

