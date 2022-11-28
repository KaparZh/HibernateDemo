package org.kaparzh.hibernatedemo.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.repository.LabelRepository;
import org.kaparzh.hibernatedemo.utils.HibernateUtils;

import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label save(Label label) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(label);
            transaction.commit();
        }
        return label;
    }

    @Override
    public Label update(Label label) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(label);
            transaction.commit();
        }
        return label;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Label label = session.get(Label.class, id);
            session.remove(label);
            transaction.commit();
        }
    }

    @Override
    public Label getById(Integer id) {
        Label label;
        try (Session session = HibernateUtils.getSession()) {
            label = session.get(Label.class, id);
        }
        return label;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels;
        try (Session session = HibernateUtils.getSession()) {
            labels = session.createQuery("FROM Label", Label.class).getResultList();
        }
        return labels;
    }
}
