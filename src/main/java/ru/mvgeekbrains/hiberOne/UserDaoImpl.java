package ru.mvgeekbrains.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public UserDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public User findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }

    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            return users;

        }
    }

    @Override
    public User findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.createQuery("select u from User u where u.name= :name", User.class).setParameter("name", name).getSingleResult();
            session.getTransaction().commit();
            return user;

        }
    }

    @Override
    public void save(User user) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();

        }
    }

    @Override
    public void update(Long id, String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
//            session.createQuery("update User u set u.name :name where u.id = :id").setParameter("name", name).setParameter("id", id).executeUpdate();
            User user = session.get(User.class, id);
            user.setName(name);
            session.getTransaction().commit();

        }
    }
//    @Override
//    public void testCache(){
//
//
//    }
}
