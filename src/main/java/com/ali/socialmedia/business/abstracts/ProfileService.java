package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileService {
    UpdateProfileRequest update(UpdateProfileRequest request, @RequestParam("image") MultipartFile image) throws IOException;
}
