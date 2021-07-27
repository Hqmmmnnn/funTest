package com.example.funtest.models;

import lombok.Data;

import java.util.List;

@Data
public class RequestPostDTO {
    private String title;
    private List<Long> tags;
}
