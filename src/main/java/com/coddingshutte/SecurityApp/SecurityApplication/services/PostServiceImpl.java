package com.coddingshutte.SecurityApp.SecurityApplication.services;

import com.coddingshutte.SecurityApp.SecurityApplication.dto.PostDTO;
import com.coddingshutte.SecurityApp.SecurityApplication.entity.PostEntity;
import com.coddingshutte.SecurityApp.SecurityApplication.entity.User;
import com.coddingshutte.SecurityApp.SecurityApplication.exception.ResourceNotFoundException;
import com.coddingshutte.SecurityApp.SecurityApplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository  postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info(String.valueOf(user));

        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+ postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+ postId));
        modelMapper.map(inputPost, olderPost);
        olderPost.setId(postId);
        return modelMapper.map(postRepository.save(olderPost), PostDTO.class);
    }


}
