package com.year2b.plannerproject.models;

import com.year2b.plannerproject.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TodoDAO {

    public void saveOrUpdate(Todo todo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Todo findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Todo todo = session.get(Todo.class, id);
        session.close();
        return todo;
    }

    public void delete(Todo todo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

