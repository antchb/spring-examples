package com.antchb.examples.spring.rest.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.antchb.examples.spring.rest.entity.User;

@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);

        return session.createQuery(criteria).getResultList();
    }

    @Override
    public Optional<User> get(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return Optional.ofNullable(session.get(User.class, id));
    }

    @Override
    public void add(User user) {
       Session session = sessionFactory.getCurrentSession();
       session.persist(user);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        
        if (user != null) {
            session.remove(user);
        }
    }

    @Override
    public void update(Long id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User dbUser = session.get(User.class, id);

        if (dbUser != null) {
            dbUser.updateValues(user);
        }
    }

}
