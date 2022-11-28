package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.repository.PostRepository;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Post save(Post post) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(post);
            transaction.commit();
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(post);
            transaction.commit();
        }
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Post post = session.get(Post.class, id);
            session.delete(post);
            transaction.commit();
        }
    }

    @Override
    public Post getById(Integer id) {
        Post post;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            post = session.get(Post.class, id);
            transaction.commit();
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            postList = session.createQuery("FROM Post").list();
            transaction.commit();
        }
        return postList;
    }
}
