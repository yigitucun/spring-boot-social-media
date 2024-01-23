package com.ali.socialmedia.business.rules;

import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.dataAccess.abstracts.IPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostBusinessRules {
    private final IPostRepository postRepository;

    public PostBusinessRules(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void checkIfPostIdExists(int id){
        if (!this.postRepository.existsById(id)){
            throw new BusinessException("Post not found", HttpStatus.BAD_REQUEST);
        }
    }
}
