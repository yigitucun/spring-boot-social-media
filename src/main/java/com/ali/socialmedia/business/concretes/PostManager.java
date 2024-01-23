package com.ali.socialmedia.business.concretes;

import com.ali.socialmedia.business.abstracts.PostService;
import com.ali.socialmedia.business.rules.UserBusinessRules;
import com.ali.socialmedia.core.dto.requests.AddPostRequest;
import com.ali.socialmedia.core.utils.fileService.FileService;
import com.ali.socialmedia.core.utils.modelMapper.ModelMapperService;
import com.ali.socialmedia.dataAccess.abstracts.IPostRepository;

import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import com.ali.socialmedia.entities.concretes.Post;
import com.ali.socialmedia.entities.concretes.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PostManager implements PostService {
    private final IPostRepository postRepository;
    private final ModelMapperService mapperService;
    private final UserBusinessRules userBusinessRules;
    private final IUserRepository userRepository;
    private final FileService fileService;

    public PostManager(IPostRepository postRepository, ModelMapperService mapperService, UserBusinessRules userBusinessRules, IUserRepository userRepository, FileService fileService) {
        this.postRepository = postRepository;
        this.mapperService = mapperService;
        this.userBusinessRules = userBusinessRules;
        this.userRepository = userRepository;
        this.fileService = fileService;
    }

    @Override
    public AddPostRequest add(MultipartFile file, AddPostRequest request) throws IOException {
        this.userBusinessRules.checkIfUserId(request.getUserId());
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        this.fileService.uploadFile(file,fileName);
        Post post = this.mapperService.toEntity(Post.class,request);
        post.setPostImageUrl(fileName);
        this.postRepository.save(post);
        return request;
    }
}
