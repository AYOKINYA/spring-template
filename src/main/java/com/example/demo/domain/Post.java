package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    private String postName;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private Instant createdDate;

    @Builder
    public Post(String postName, String description, User user, Instant createdDate) {
        this.postName = postName;
        this.description = description;
        this.user = user;
        this.createdDate = createdDate;
    }

    public void updatePost(String postName, String description) {
        this.postName = postName;
        this.description = description;
    }

}
