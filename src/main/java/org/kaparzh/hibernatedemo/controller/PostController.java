package org.kaparzh.hibernatedemo.controller;

import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.service.PostService;
import org.kaparzh.hibernatedemo.service.impl.PostServiceImpl;

import java.util.List;

public class PostController {

    private final PostService postService = new PostServiceImpl();

    public Post createPost(String content, List<Label> labels) {
        return postService.create(content, labels);
    }

    public Post updatePost(int id, String content) {
        return postService.update(id, content);
    }

    public void deleteById(int id) {
        postService.delete(id);
    }

    public Post getById(int id) {
        return postService.getById(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }
}
