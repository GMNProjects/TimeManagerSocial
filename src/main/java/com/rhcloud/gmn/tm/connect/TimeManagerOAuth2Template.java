package com.rhcloud.gmn.tm.connect;

import com.rhcloud.gmn.tm.timer.TimerFactory;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.client.RestTemplate;

/**
 * @author GMNProjects
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

