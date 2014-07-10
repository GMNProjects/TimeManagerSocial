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
import com.rhcloud.gmn.tm.api.TimeManagerProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

/**
 * @author GMNProjects
 */
public class TimeManagerAdapter implements ApiAdapter<TimeManager> {
    @Override
    public boolean test(TimeManager api) {
        return false;
    }

    @Override
    public void setConnectionValues(TimeManager api, ConnectionValues values) {
        TimeManagerProfile profile = api.userOperations().getUser();
        values.setProviderUserId(profile.getU_id());
        values.setDisplayName(profile.getFirstName() + " " + profile.getLastName());
        values.setProviderUserId(profile.getU_id());
    }

    @Override
    public UserProfile fetchUserProfile(TimeManager api) {
        TimeManagerProfile profile = api.userOperations().getUser();
        return new UserProfileBuilder().setEmail(profile.getEmail())
                .setFirstName(profile.getFirstName())
                .setLastName(profile.getLastName())
                .setUsername(profile.getEmail())
                .setName(profile.getFirstName() + " " + profile.getLastName())
                .build();
    }

    @Override
    public void updateStatus(TimeManager api, String message) {

    }
}
