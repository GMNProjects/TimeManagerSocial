package com.rhcloud.gmn.tm.connect;

import com.rhcloud.gmn.tm.api.TimeManager;
import com.rhcloud.gmn.tm.api.impl.TimeManagerTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

/**
 * Created by niaz on 06.07.2014.
 */
public class TimeManagerServiceProvider extends AbstractOAuth2ServiceProvider<TimeManager> {

    /**
     * Create a new {@link com.rhcloud.gmn.tm.connect.TimeManagerServiceProvider}.
     *
     * @param clientId
     */
    public TimeManagerServiceProvider(String clientId,String clientSecret) {
        super(new TimeManagerOAuth2Template(clientId,clientSecret));
    }

    @Override
    public TimeManager getApi(String accessToken) {
        return new TimeManagerTemplate(accessToken);
    }
}
