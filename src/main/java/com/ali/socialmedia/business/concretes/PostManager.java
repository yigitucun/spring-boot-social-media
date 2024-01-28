package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.PostService;
import com.ali.socialmedia.business.rules.PostBusinessRules;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.AddPostRequest;
import com.ali.socialmedia.core.dto.requests.UpdatePostRequest;
import com.ali.socialmedia.core.exceptions.businessException.BusinessException;
import com.ali.socialmedia.projections.post.IFindPostByIdAndUserIdProjection;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.IPostRepository;

import com.ali.socialmedia.entities.concretes.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PostManager implements PostService {
    private final IPostRepository postRepository;
    private final ModelMapperService mapperService;
    private final UserBusinessRules userBusinessRules;
    private final PostBusinessRules postBusinessRules;


    public PostManager(IPostRepository postRepository, ModelMapperService mapperService, UserBusinessRules userBusinessRules, PostBusinessRules postBusinessRules) {
        this.postRepository = postRepository;
        this.mapperService = mapperService;
        this.userBusinessRules = userBusinessRules;
        this.postBusinessRules = postBusinessRules;
    }

    @Override
    public UpdatePostRequest update(UpdatePostRequest request) {
        this.userBusinessRules.checkIfUserId(request.getUserId());
        this.postBusinessRules.checkIfPostIdExists(request.getId());

        Post post = this.mapperService.toEntity(Post.class,request);
        this.postRepository.save(post);

        return request;
    }

    @Override
    public void deleteById(int userId,int postId)  {
        this.postBusinessRules.checkIfPostIdExists(postId);
        this.userBusinessRules.checkIfUserId(userId);
        IFindPostByIdAndUserIdProjection post = this.postRepository.findByIdAndUserId(postId,userId)
                .orElseThrow(()->new BusinessException("Unauthorized transaction", HttpStatus.UNAUTHORIZED));
        this.postRepository.deleteById(post.getId());
    }


    @Override
    public AddPostRequest add(AddPostRequest request) {
        this.userBusinessRules.checkIfUserId(request.getUserId());
        Post post = this.mapperService.toEntity(Post.class,request);
        this.postRepository.save(post);
        return request;
    }
}
