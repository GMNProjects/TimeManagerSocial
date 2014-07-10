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

import com.rhcloud.gmn.tm.api.TimeManager;
import com.rhcloud.gmn.tm.api.impl.TimeManagerTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

/**
 * @author GMNProjects
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
