package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    private Long memberId;

    private String memberName;

    private String password;

    private String email;

    private Instant created;

    private boolean enabled;

    public void updateEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ManyToMany
    @JoinTable(name = "member_roles",
            joinColumns = @JoinColumn(name = "member_member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void updateRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Builder
    public Member(String memberName, String password, String email, Instant created, Boolean enabled, Set<Role> roles) {
        this.memberName = memberName;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enabled = enabled;
        this.roles = roles;
    }

}
