package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.ProfileService;
import com.ali.socialmedia.business.rules.ProfileBusinessRules;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.IProfileRepository;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import com.ali.socialmedia.entities.concretes.Profile;
import com.ali.socialmedia.entities.concretes.User;
import com.ali.socialmedia.projections.profile.IDetailProfileProjection;
import com.ali.socialmedia.projections.user.IUserProjection;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileManager implements ProfileService {
    private final IProfileRepository profileRepository;
    private final ModelMapperService mapperService;
    private final UserBusinessRules userBusinessRules;
    private final ProfileBusinessRules profileBusinessRules;
    private final IUserRepository userRepository;

    public ProfileManager(IProfileRepository profileRepository, ModelMapperService mapperService, UserBusinessRules userBusinessRules, ProfileBusinessRules profileBusinessRules, IUserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.mapperService = mapperService;
        this.userBusinessRules = userBusinessRules;
        this.profileBusinessRules = profileBusinessRules;
        this.userRepository = userRepository;
    }

    @Override
    public Profile detail(int id) {
        this.profileBusinessRules.checkIfProfileId(id);
        return this.profileRepository.findById(id).orElseThrow();
    }

    @Override
    public void follow(int followedUserId, int followingUserId) {
        this.userBusinessRules.checkIfUserId(followedUserId);
        this.userBusinessRules.checkIfUserId(followingUserId);

        Profile followedProfile = this.profileRepository.findByUserId(followedUserId);
        Profile followingProfile = this.profileRepository.findByUserId(followingUserId);

        followedProfile.getFollowers().add(followingProfile.getUser());
        followingProfile.getFollowings().add(followedProfile.getUser());
        this.profileRepository.save(followedProfile);
        this.profileRepository.save(followingProfile);



    }

    @Override
    public UpdateProfileRequest update(UpdateProfileRequest request){
        this.userBusinessRules.checkIfUserId(request.getUserId());
        this.profileBusinessRules.checkIfProfileId(request.getId());
        Profile profile = this.mapperService.toEntity(Profile.class,request);
        this.profileRepository.save(profile);
        return request;
    }
}

















