package com.rhcloud.gmn.tm.api.entity;

/**
* @author GMNProjects
*/
public class RESTError {
    private String error;
    private String error_description;

    public RESTError(String error, String error_description) {
        this.error = error;
        this.error_description = error_description;
    }

    public RESTError() {
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
