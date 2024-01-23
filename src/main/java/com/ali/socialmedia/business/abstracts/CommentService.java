package com.ali.socialmedia.business.abstracts;

import com.ali.socialmedia.core.dto.requests.AddCommentRequest;


public interface CommentService {
    AddCommentRequest add(AddCommentRequest request);
}
