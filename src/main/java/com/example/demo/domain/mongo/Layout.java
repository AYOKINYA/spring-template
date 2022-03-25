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
    private String layoutName;
    private Boolean isVideoOn;
    private List<Item> items;

    public Layout(String layoutName, List<Item> items, Boolean isVideoOn) {
        this.layoutId = ObjectId.get().toHexString();
        this.layoutName = layoutName;
        this.items = items;
        this.isVideoOn = isVideoOn;
    }

    public Layout(String layoutId, String layoutName, List<Item> items, Boolean isVideoOn) {
        this.layoutId = layoutId;
        this.layoutName = layoutName;
        this.items = items;
        this.isVideoOn = isVideoOn;
    }
}
