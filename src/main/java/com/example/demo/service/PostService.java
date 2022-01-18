package com.example.demo.service;


import com.example.demo.Exception.PostNotFoundException;
import com.example.demo.domain.Post;
import com.example.demo.domain.PostRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.web.dto.PostRequest;
import com.example.demo.web.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    @Transactional
    public void save(PostRequest postRequest) {

        postRepository.save(dtoToPost(postRequest));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::new)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException(id.toString()));
        return new PostResponse(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(PostResponse::new)
                .collect(toList());
    }

    @Transactional
    public void update(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException(id.toString()));

        post.updatePost(postRequest.getPostName(), postRequest.getDescription());
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException(id.toString()));

        postRepository.delete(post);
    }

    private Post dtoToPost(PostRequest postRequest) {
        return Post.builder()
                .postName(postRequest.getPostName())
                .description(postRequest.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(Instant.now())
                .build();
    }

}