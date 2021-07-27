package com.example.funtest.services;

import com.example.funtest.models.Post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PostServiceImpl implements PostService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Post post) {
        entityManager.persist(post);
    }

    @Transactional(readOnly = true)
    public Post findById(Long postId) {
        return entityManager.find(Post.class, postId);
    }
}
