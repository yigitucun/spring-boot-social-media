package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import com.ali.socialmedia.entities.concretes.Profile;
import com.ali.socialmedia.projections.profile.IDetailProfileProjection;

public interface ProfileService {
    UpdateProfileRequest update(UpdateProfileRequest request);
    Profile detail(int id);
    void follow(int followedUserId,int followingUserId);
}
