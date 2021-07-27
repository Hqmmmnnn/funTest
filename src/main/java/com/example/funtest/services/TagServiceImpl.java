package com.example.funtest.services;

import com.example.funtest.models.Tag;
import com.example.funtest.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Tag tag) {
        entityManager.persist(tag);
    }

    @Transactional(readOnly = true)
    public List<Tag> getAllByIdIn(List<Long> tagIds) {
        return tagRepository.findAllByIdIn(tagIds);
    }
}
