package com.ali.socialmedia.business.rules;

import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.dataAccess.abstracts.ICommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentBusinessRules {
    private final ICommentRepository commentRepository;

    public CommentBusinessRules(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public void checkIfCommentIdExists(int id){
        if (!this.commentRepository.existsById(id)){
            throw new BusinessException("Comment not found", HttpStatus.BAD_REQUEST);
        }
    }
}
