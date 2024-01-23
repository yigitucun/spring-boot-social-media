package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.CommentService;
import com.ali.socialmedia.business.rules.PostBusinessRules;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.AddCommentRequest;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.ICommentRepository;
import com.ali.socialmedia.entities.concretes.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentManager implements CommentService {
    private final ICommentRepository commentRepository;
    private final UserBusinessRules userBusinessRules;
    private final ModelMapperService mapperService;
    private final PostBusinessRules postBusinessRules;

    public CommentManager(ICommentRepository commentRepository, UserBusinessRules userBusinessRules, ModelMapperService mapperService, PostBusinessRules postBusinessRules) {
        this.commentRepository = commentRepository;
        this.userBusinessRules = userBusinessRules;
        this.mapperService = mapperService;
        this.postBusinessRules = postBusinessRules;
    }

    @Override
    public AddCommentRequest add(AddCommentRequest request) {
        this.userBusinessRules.checkIfUserId(request.getUserId());
        this.postBusinessRules.checkIfPostIdExists(request.getPostId());
        Comment comment  = this.mapperService.toEntity(Comment.class,request);
        this.commentRepository.save(comment);
        return request;
    }
}
