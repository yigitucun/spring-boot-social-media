package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.AddPostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PostService {
    AddPostRequest add(MultipartFile file,AddPostRequest request) throws IOException;
}
