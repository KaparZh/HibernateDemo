package org.kaparzh.hibernatedemo.service;

import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.model.Writer;

import java.util.List;

public interface WriterService extends GenericService<Writer, Integer> {

    Writer create(String firstName, String lastName, List<Post> postList);

    Writer update(Integer id, String firstName, String lastName);
}
