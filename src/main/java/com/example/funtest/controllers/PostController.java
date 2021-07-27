package com.example.funtest.controllers;

import com.example.funtest.models.Post;
import com.example.funtest.models.RequestPostDTO;
import com.example.funtest.models.ResponsePostDTO;
import com.example.funtest.models.Tag;
import com.example.funtest.services.PostService;
import com.example.funtest.services.TagService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
    private final TagService tagService;

    @PostMapping("/posts")
    public void create(@RequestBody RequestPostDTO dto) {
        logger.info("Initial data from dto {}", dto.toString());
        Post newPost = new Post(dto.getTitle());
        List<Tag> tags = tagService.getAllByIdIn(dto.getTags());
        tags.forEach(newPost::addTag);
        postService.create(newPost);
    }

    @GetMapping("/posts/{postId}")
    public ResponsePostDTO findPost(@PathVariable Long postId) {
        Post post = postService.findById(postId);
        List<String> tagsNames = post.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());

        return new ResponsePostDTO(post.getTitle(), tagsNames);
    }
}
