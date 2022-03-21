package com.example.demo.domain.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

//inner Document는 자동으로 ObjectId가 생성되지 않기 때문에 생성자에서 반드시 넣어줘야 한다.
@Getter
@NoArgsConstructor
public class Layout {
    @Id
    private String layoutId;
    private List<Item> items;

    public Layout(List<Item> items) {
        this.layoutId = ObjectId.get().toHexString();
        this.items = items;
    }
}
