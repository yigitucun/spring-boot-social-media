package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.AddPostRequest;
import com.ali.socialmedia.core.dto.requests.UpdatePostRequest;

public interface PostService {
    AddPostRequest add(AddPostRequest request);
    void deleteById(int userId, int postId);
    UpdatePostRequest update(UpdatePostRequest request);
}
