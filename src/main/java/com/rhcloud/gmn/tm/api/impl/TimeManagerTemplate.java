/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.*;
import com.rhcloud.gmn.tm.connect.CustomResponseErrorHandler;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.web.client.RestTemplate;

/**
 * @author GMNProjects
 *
 * {@link TimeManager} implementation
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
