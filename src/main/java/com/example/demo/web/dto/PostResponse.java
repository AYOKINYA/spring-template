package com.example.demo.web.dto;

import com.example.demo.domain.Post;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String postName;
    private String description;
    private String userName;

    public PostResponse(Post post) {
        this.id = post.getPostId();
        this.postName = post.getPostName();
        this.description = post.getDescription();
        this.userName = post.getUser().getUsername();
    }
}