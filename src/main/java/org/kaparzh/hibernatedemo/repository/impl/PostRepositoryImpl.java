package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.repository.PostRepository;
import org.kaparzh.hibernatedemo.utils.HibernateUtils;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post save(Post post) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(post);
            transaction.commit();
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(post);
            transaction.commit();
        }
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Post post = session.get(Post.class, id);
            session.remove(post);
            transaction.commit();
        }
    }

    @Override
    public Post getById(Integer id) {
        Post post;
        try (Session session = HibernateUtils.getSession()) {
            post = session.createQuery("FROM Post p LEFT JOIN FETCH p.labels WHERE p.id = " + id, Post.class)
                    .getSingleResult();
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList;
        try (Session session = HibernateUtils.getSession()) {
            postList = session.createQuery("FROM Post p LEFT JOIN FETCH p.labels", Post.class)
                    .getResultList();
        }
        return postList;
    }
}
