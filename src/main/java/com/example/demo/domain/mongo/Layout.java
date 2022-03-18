package com.example.demo.domain.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@Getter
@NoArgsConstructor
public class Layout {
    @Id
    private ObjectId layoutId;
    private List<Item> items;

    public Layout(List<Item> items) {
        this.layoutId = ObjectId.get();
        this.items = items;
    }
}
