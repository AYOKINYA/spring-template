package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {

    @Id
    private Long memberId;

    private String username;

    private String password;

    private String email;

}
