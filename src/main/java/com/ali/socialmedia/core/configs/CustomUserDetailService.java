package com.ali.socialmedia.core.configs;

import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import com.ali.socialmedia.entities.concretes.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final IUserRepository userRepository;

    public CustomUserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user != null){
            return user;
        }
        throw new BusinessException("Kullanıcı adı veya şifre hatalı.", HttpStatus.BAD_REQUEST);
    }
}
