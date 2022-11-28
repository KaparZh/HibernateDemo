package org.kaparzh.hibernatedemo.service.impl;

import org.junit.jupiter.api.Test;
import org.kaparzh.hibernatedemo.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PostServiceImplTest {

    private final LocalDateTime created = LocalDateTime.now();

    private final Post post1 = new Post(1, "Post#1", created, created, new ArrayList<>());
    private final Post post2 = new Post(2, "Post#2", created, created, new ArrayList<>());
    private final Post post3 = new Post(3, "Post#3", created, created, new ArrayList<>());

    private final List<Post> posts = List.of(post1, post2, post3);

    private final PostServiceImpl service = mock(PostServiceImpl.class);

    @Test
    void testGetById() {
        when(service.getById(1)).thenReturn(post1);
        assertEquals(post1, service.getById(1));
    }

    @Test
    void testGetByIdShouldReturnIncorrectValue() {
        when(service.getById(1)).thenReturn(post1);
        assertNotEquals(post2, service.getById(1));
    }

    @Test
    void testDelete() {
        service.delete(1);
        verify(service, times(1)).delete(eq(1));
    }

    @Test
    void testGetAll() {
        when(service.getAll()).thenReturn(posts);
        assertEquals(posts, service.getAll());
    }

    @Test
    void testGetAllShouldReturnIncorrectValue() {
        when(service.getAll()).thenReturn(posts);
        assertNotEquals(new ArrayList<>(), service.getAll());
    }

    @Test
    void testCreate() {
        Post newPost = new Post(4, "NewPost", created, created, new ArrayList<>());
        when(service.create("NewPost", new ArrayList<>())).thenReturn(newPost);
        assertEquals(newPost, service.create("NewPost", new ArrayList<>()));
    }

    @Test
    void testCreateShouldReturnIncorrectValue() {
        Post newPost = new Post(4, "NewPost", created, created, new ArrayList<>());
        when(service.create("NewPost", new ArrayList<>())).thenReturn(newPost);
        assertNotEquals(post1, service.create("NewPost", new ArrayList<>()));
    }

    @Test
    void testUpdate() {
        LocalDateTime updated = LocalDateTime.now();
        Post updatedPost = new Post(2, "UpdatedPost", created, updated, new ArrayList<>());
        when(service.update(2, "UpdatedPost")).thenReturn(updatedPost);
        assertEquals(updatedPost, service.update(2, "UpdatedPost"));
    }

    @Test
    void testUpdateShouldReturnIncorrectValue() {
        LocalDateTime updated = LocalDateTime.now();
        Post updatedPost = new Post(2, "UpdatedPost", created, updated, new ArrayList<>());
        when(service.update(2, "UpdatedPost")).thenReturn(updatedPost);
        assertNotEquals(post1, service.update(2, "UpdatedPost"));
    }
}