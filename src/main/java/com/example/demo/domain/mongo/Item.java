package com.example.demo.domain.mongo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//내장 도큐먼트에는 @Document를 설정하지 않는다.
@Getter
@NoArgsConstructor
public class Item {

    private String i;
    private int x;
    private int y;
    private int w;
    private int h;
    private int minW;
    private int minH;

    @JsonProperty("static")
    private boolean isStatic;

    @Builder
    public Item(int i, int x, int y, int w, int h, int minW, int minH, boolean isStatic) {
        this.i = Integer.toString(i);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.minW = minW;
        this.minH = minH;
        this.isStatic = isStatic;
    }
}
