package com.example.demo.domain.mongo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "layouts")
@Getter
public class Layout {
    @Id
    private String layoutId;
    private List<Item> items;

    @Builder
    public Layout(List<Item> items) {
        this.items = items;
    }
}
