package com.example.demo.domain.mongo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.List;

@Document(collection = "layout_users")
@Getter
public class LayoutUser {

    @Id
    private Long userId;
    List<Layout> layouts;

    @Builder
    public LayoutUser(Long userId, List<Layout> layouts) {
        this.userId = userId;
        this.layouts = layouts;
    }
}
