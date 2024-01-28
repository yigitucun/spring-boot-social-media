package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.CommentService;
import com.ali.socialmedia.business.rules.CommentBusinessRules;
import com.ali.socialmedia.business.rules.PostBusinessRules;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.AddCommentRequest;
import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.ICommentRepository;
import com.ali.socialmedia.entities.concretes.Comment;
import com.ali.socialmedia.projections.comment.ICommentGetByIdAndUserIdProjection;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentManager implements CommentService {
    private final ICommentRepository commentRepository;
    private final UserBusinessRules userBusinessRules;
    private final ModelMapperService mapperService;
    private final PostBusinessRules postBusinessRules;
    private final CommentBusinessRules commentBusinessRules;


    public CommentManager(ICommentRepository commentRepository, UserBusinessRules userBusinessRules, ModelMapperService mapperService, PostBusinessRules postBusinessRules, CommentBusinessRules commentBusinessRules) {
        this.commentRepository = commentRepository;
        this.userBusinessRules = userBusinessRules;
        this.mapperService = mapperService;
        this.postBusinessRules = postBusinessRules;
        this.commentBusinessRules = commentBusinessRules;
    }

    @Override
    public void delete(int commentId, int userId) {
        this.userBusinessRules.checkIfUserId(userId);
        this.commentBusinessRules.checkIfCommentIdExists(commentId);
        ICommentGetByIdAndUserIdProjection comment = this.commentRepository.findByIdAndUserId(commentId,userId)
                .orElseThrow(()->new BusinessException("Unauthorized transaction", HttpStatus.UNAUTHORIZED));
        System.out.println(comment.getId());
        this.commentRepository.deleteById(comment.getId());
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
