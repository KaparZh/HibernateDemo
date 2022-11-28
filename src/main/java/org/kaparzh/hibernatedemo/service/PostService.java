package org.kaparzh.hibernatedemo.service;

import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.model.Post;

import java.util.List;

public interface PostService extends GenericService<Post, Integer> {

    Post create(String content, List<Label> labels);

    Post update(Integer id, String content);
}
