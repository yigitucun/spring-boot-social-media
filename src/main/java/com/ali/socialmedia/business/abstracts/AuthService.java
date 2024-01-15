package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.AddUserRequest;
import com.ali.socialmedia.core.dto.requests.AuthenticateRequest;
import com.ali.socialmedia.core.dto.responses.TokenResponse;

public interface AuthService {
    AddUserRequest add(AddUserRequest request);
    TokenResponse authenticate(AuthenticateRequest request);
}
