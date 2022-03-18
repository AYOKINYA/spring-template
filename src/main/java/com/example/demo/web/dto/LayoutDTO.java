package com.example.demo.web.dto;

import com.example.demo.domain.mongo.Layout;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LayoutDTO {
     private String username;
     private List<Layout> layouts;
}


