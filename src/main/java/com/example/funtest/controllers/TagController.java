package com.example.funtest.controllers;

import com.example.funtest.models.Tag;
import com.example.funtest.models.TagRequestDTO;
import com.example.funtest.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/tags")
    public void saveTag(@RequestBody TagRequestDTO tagDto) {
        tagService.create(new Tag(tagDto.getName()));
    }
}
