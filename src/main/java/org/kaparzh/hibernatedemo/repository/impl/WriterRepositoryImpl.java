package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kaparzh.hibernatedemo.model.Writer;
import org.kaparzh.hibernatedemo.repository.WriterRepository;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Writer save(Writer writer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(writer);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(writer);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Writer writer = session.get(Writer.class, id);
            session.delete(writer);
            transaction.commit();
        }
    }

    @Override
    public Writer getById(Integer id) {
        Writer writer;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            writer = session.get(Writer.class, id);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            writers = session.createQuery("FROM Writer").list();
            transaction.commit();
        }
        return writers;
    }
}
