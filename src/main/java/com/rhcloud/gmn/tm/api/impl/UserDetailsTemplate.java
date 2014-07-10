package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.TimeManagerProfile;
import com.rhcloud.gmn.tm.api.UserOperations;
import com.rhcloud.gmn.tm.api.entity.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by niaz on 06.07.2014.
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
