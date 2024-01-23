package com.ali.socialmedia.business.rules;

import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.dataAccess.abstracts.IProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProfileBusinessRules {
    private final IProfileRepository profileRepository;

    public ProfileBusinessRules(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void checkIfProfileId(int id){
        if (!this.profileRepository.existsById(id)){
            throw new BusinessException("Profile not found", HttpStatus.BAD_REQUEST);
        }
    }

}
