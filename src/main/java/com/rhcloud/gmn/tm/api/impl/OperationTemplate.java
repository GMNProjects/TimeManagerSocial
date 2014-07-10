package com.rhcloud.gmn.tm.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.MultiValueMap;

import java.net.URI;

/**
 * Created by niaz on 06.07.2014.
 */
public class OperationTemplate {
    public static final String RESTURL = "https://tm-gmn.rhcloud.com:8443/api/";
    private boolean isAuthorized;
    private String access_token;

    public OperationTemplate(boolean isAuthorized, String access_token) {
        this.isAuthorized = isAuthorized;
        this.access_token = access_token;
    }

    protected void checkAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("TimeManager");
        }
    }

    protected URI buildOperation(String method, MultiValueMap<String, String> params) {
        URIBuilder uriBuilder = URIBuilder.fromUri(RESTURL + method);
        uriBuilder.queryParam("access_token", access_token);
        if (params != null) {
            uriBuilder.queryParams(params);
        }
        return uriBuilder.build();
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}
