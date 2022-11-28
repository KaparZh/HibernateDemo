package org.kaparzh.hibernatedemo.service.impl;

import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.repository.PostRepository;
import org.kaparzh.hibernatedemo.repository.impl.PostRepositoryImpl;
import org.kaparzh.hibernatedemo.service.PostService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post getById(Integer id) {
        return postRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post create(String content, List<Label> labels) {
        LocalDateTime created = LocalDateTime.now();
        return postRepository.save(new Post(1, content, created, created, labels));
    }

    @Override
    public Post update(Integer id, String content) {
        LocalDateTime updated = LocalDateTime.now();
        return postRepository.update(new Post(id, content, updated, updated, new ArrayList<>()));
    }
}
