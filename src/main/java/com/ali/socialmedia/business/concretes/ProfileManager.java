package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.ProfileService;
import com.ali.socialmedia.business.rules.ProfileBusinessRules;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import com.ali.socialmedia.core.utils.fileService.FileService;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.IProfileRepository;
import com.ali.socialmedia.entities.concretes.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfileManager implements ProfileService {
    private final IProfileRepository profileRepository;
    private final ModelMapperService mapperService;
    private final FileService fileService;
    private final UserBusinessRules userBusinessRules;
    private final ProfileBusinessRules profileBusinessRules;

    public ProfileManager(IProfileRepository profileRepository, ModelMapperService mapperService, FileService fileUploadService, UserBusinessRules userBusinessRules, ProfileBusinessRules profileBusinessRules) {
        this.profileRepository = profileRepository;
        this.mapperService = mapperService;
        this.fileService = fileUploadService;
        this.userBusinessRules = userBusinessRules;
        this.profileBusinessRules = profileBusinessRules;
    }
    @Override
    public UpdateProfileRequest update(UpdateProfileRequest request, @RequestParam("image") MultipartFile file) throws IOException {
        this.userBusinessRules.checkIfUserId(request.getUserId());
        this.profileBusinessRules.checkIfProfileId(request.getId());

        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        Profile user = this.profileRepository.findById(request.getId());

        this.fileService.deleteIfExists(user.getProfilePhotoUrl());
        this.fileService.uploadFile(file,fileName);

        Profile profile = this.mapperService.toEntity(Profile.class,request);
        profile.setProfilePhotoUrl(fileName);
        request.setProfilePhotoUrl(fileName);
        this.profileRepository.save(profile);

        return request;
    }
}

















