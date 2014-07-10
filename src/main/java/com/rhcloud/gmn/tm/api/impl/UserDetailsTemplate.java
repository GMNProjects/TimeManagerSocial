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

import com.rhcloud.gmn.tm.api.TimeManagerProfile;
import com.rhcloud.gmn.tm.api.UserOperations;
import com.rhcloud.gmn.tm.api.entity.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author GMNProjects
 *
 * {@link UserOperations} implementation
 */
public class UserDetailsTemplate extends OperationTemplate implements UserOperations {

    private String access_token;
    private RestTemplate restTemplate;

    public UserDetailsTemplate(boolean isAuthorized, String access_token, RestTemplate restTemplate) {
        super(isAuthorized, access_token);
        this.access_token = access_token;
        this.restTemplate = restTemplate;
    }

    @Override
    public TimeManagerProfile getUser() {
        checkAuthorization();
        URI uri = buildOperation(UserDetails.USER_GET, null);
        ResponseEntity<UserDetails> clientResponseEntity = restTemplate.getForEntity(uri, UserDetails.class);
        UserDetails ud = clientResponseEntity.getBody();
        TimeManagerProfile tmpf = new TimeManagerProfile(ud.getU_id(), ud.getFirstName(), ud.getLastName(), ud.getEmail());
        return tmpf;
    }
}
