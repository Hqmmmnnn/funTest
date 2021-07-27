package com.example.funtest.services;

import com.example.funtest.models.Post;

public interface PostService {
    void create(Post post);
    Post findById(Long postId);
}
