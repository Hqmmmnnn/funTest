package com.example.funtest.repositories;

import com.example.funtest.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByIdIn(List<Long> tagsIds);
}
