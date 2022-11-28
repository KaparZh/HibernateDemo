package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.kaparzh.hibernatedemo.model.Writer;
import org.kaparzh.hibernatedemo.repository.WriterRepository;
import org.kaparzh.hibernatedemo.utils.HibernateUtils;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer save(Writer writer) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(writer);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(writer);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Writer writer = session.get(Writer.class, id);
            session.remove(writer);
            transaction.commit();
        }
    }

    @Override
    public Writer getById(Integer id) {
        Writer writer;
        try (Session session = HibernateUtils.getSession()) {
            writer = session.get(Writer.class, id);
        }
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;
        try (Session session = HibernateUtils.getSession()) {
            writers = session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts", Writer.class).getResultList();
        }
        return writers;
    }
}
