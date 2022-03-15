package com.example.demo.domain.mongo;

import lombok.Builder;
import lombok.Getter;

//내장 도큐먼트에는 @Document를 설정하지 않는다.
@Getter
public class Item {

    private int i;
    private int x;
    private int y;
    private int w;
    private int h;
    private int maxW;
    private int maxH;
    private boolean isStatic;

    @Builder
    public Item(int x, int y, int w, int h, int maxW, int maxH, boolean isStatic) {

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.maxW = maxW;
        this.maxH = maxH;
        this.isStatic = isStatic;

    }
}
