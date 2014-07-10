package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.*;
import com.rhcloud.gmn.tm.connect.CustomResponseErrorHandler;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.web.client.RestTemplate;

/**
 * Created by niaz on 06.07.2014.
 */
public class TimeManagerTemplate extends AbstractOAuth2ApiBinding implements TimeManager {

    private ClientOperations clientOperations;
    private UserOperations userOperations;
    private ServiceOperations serviceOperations;
    private WorkOperations workOperations;
    private final String accessToken;

    public TimeManagerTemplate(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
        initApis();
    }

    private void initApis() {
        workOperations = new WorkTemplate(isAuthorized(),accessToken,getRestTemplate());
        userOperations = new UserDetailsTemplate(isAuthorized(),accessToken,getRestTemplate());
        clientOperations = new ClientTemplate(isAuthorized(), accessToken, getRestTemplate());
        serviceOperations = new ServiceTemplate(isAuthorized(),accessToken,getRestTemplate());
    }

    @Override
    public ClientOperations clientOperations() {
        return clientOperations;
    }

    @Override
    public WorkOperations workOperations() {
        return workOperations;
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    public ServiceOperations serviceOperations() {
        return serviceOperations;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
    }
}
