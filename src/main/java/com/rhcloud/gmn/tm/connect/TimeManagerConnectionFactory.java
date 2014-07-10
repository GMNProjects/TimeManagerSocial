package com.rhcloud.gmn.tm.connect;

import com.rhcloud.gmn.tm.api.TimeManager;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Created by niaz on 06.07.2014.
 */
public class TimeManagerConnectionFactory extends OAuth2ConnectionFactory<TimeManager> {

    /**
     * Фабрика коннекшкнов для TimeManager
     * @param clientId
     * @param clientSecret
     */
    public TimeManagerConnectionFactory(String clientId, String clientSecret) {
        super("TimeManager", new TimeManagerServiceProvider(clientId, clientSecret), new TimeManagerAdapter());
    }
}
