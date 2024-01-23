package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.AuthService;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.configs.CustomUserDetailService;
import com.ali.socialmedia.core.dto.requests.AddUserRequest;
import com.ali.socialmedia.core.dto.requests.AuthenticateRequest;
import com.ali.socialmedia.core.dto.responses.TokenResponse;
import com.ali.socialmedia.core.utils.jwtService.JwtService;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.IProfileRepository;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import com.ali.socialmedia.entities.concretes.Profile;
import com.ali.socialmedia.entities.concretes.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private final ModelMapperService mapperService;
    private final IUserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserBusinessRules userBusinessRules;
    private final IProfileRepository profileRepository;

    public AuthManager(ModelMapperService mapperService, IUserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtService jwtService, UserBusinessRules userBusinessRules, IProfileRepository profileRepository) {
        this.mapperService = mapperService;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userBusinessRules = userBusinessRules;
        this.profileRepository = profileRepository;
    }

    @Override
    public TokenResponse authenticate(AuthenticateRequest request) {
        this.userBusinessRules.checkIfLoginUsername(request.getUsername());
        User user = this.userRepository.findByUsername(request.getUsername());
        this.userBusinessRules.checkIfPasswordIsMatch(request.getPassword(),user.getPassword());
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        String token = jwtService.generateToken(user);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    @Override
    public AddUserRequest add(AddUserRequest request) {
        request.setPassword(this.encoder.encode(request.getPassword()));
        User user = this.mapperService.toEntity(User.class,request);
        this.userRepository.save(user);
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setProfilePhotoUrl("default.png");
        this.profileRepository.save(profile);
        return request;
    }
}
