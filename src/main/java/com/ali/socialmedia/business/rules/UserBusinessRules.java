package com.ali.socialmedia.business.rules;

import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessRules {
    private final IUserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserBusinessRules(IUserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public void checkIfPasswordIsMatch(String password,String hashPassword){
        if (!encoder.matches(password,hashPassword)){
            throw new BusinessException("Username or Password wrong", HttpStatus.BAD_REQUEST);
        }
    }
    public void checkIfLoginUsername(String username){
        if (!this.userRepository.existsByUsername(username)){
            throw new BusinessException("Username or Password wrong",HttpStatus.BAD_REQUEST);
        }
    }

}
