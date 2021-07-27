package com.example.funtest.services;

import com.example.funtest.models.Tag;

import java.util.List;

public interface TagService {
    void create(Tag tag);
    List<Tag> getAllByIdIn(List<Long> tagIds);
}
