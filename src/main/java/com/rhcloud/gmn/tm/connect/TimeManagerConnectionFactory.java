package com.rhcloud.gmn.tm.connect;

import com.rhcloud.gmn.tm.api.TimeManager;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author GMNProjects
 *
 * Custom OAuth2ConnectionFactory
 */
public class TimeManagerConnectionFactory extends OAuth2ConnectionFactory<TimeManager> {

    /**
     * Connection factory for TimeManager
     * @param clientId
     * @param clientSecret
     */
    public TimeManagerConnectionFactory(String clientId, String clientSecret) {
        super("TimeManager", new TimeManagerServiceProvider(clientId, clientSecret), new TimeManagerAdapter());
    }
}
