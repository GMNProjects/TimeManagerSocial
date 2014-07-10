package com.rhcloud.gmn.tm.connect;

import com.rhcloud.gmn.tm.api.TimeManager;
import com.rhcloud.gmn.tm.api.TimeManagerProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

/**
 * Created by niaz on 06.07.2014.
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
