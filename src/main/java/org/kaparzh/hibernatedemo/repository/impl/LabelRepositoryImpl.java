package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.repository.LabelRepository;

import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Label save(Label label) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(label);
            transaction.commit();
        }
        return label;
    }

    @Override
    public Label update(Label label) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(label);
            transaction.commit();
        }
        return label;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Label label = session.get(Label.class, id);
            session.delete(label);
            transaction.commit();
        }
    }

    @Override
    public Label getById(Integer id) {
        Label label;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            label = session.get(Label.class, id);
            transaction.commit();
        }
        return label;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            labels = session.createQuery("FROM Label").list();
            transaction.commit();
        }
        return labels;
    }
}
