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
package com.rhcloud.gmn.tm.connect;

import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.client.RestTemplate;

/**
 * @author GMNProjects
 *         <p/>
 *         TimeManager OAuth2 Template
 */
public class TimeManagerOAuth2Template extends OAuth2Template {

    public TimeManagerOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret, "https://tm-gmn.rhcloud.com:8443/oauth/authorize", "https://tm-gmn.rhcloud.com:8443/oauth/token");
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        return restTemplate;
    }
}

