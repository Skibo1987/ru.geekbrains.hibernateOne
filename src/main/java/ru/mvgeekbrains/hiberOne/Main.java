package ru.mvgeekbrains.hiberOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            UserDao userDao = new UserDaoImpl(sessionFactoryUtils);
            User user = new User("Max", 89);
            userDao.save(user);
            userDao.update(4l, "Ivan");
            System.out.println(userDao.findAll());

//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            User oldUser = session.get(User.class, 1l);
//            System.out.println(oldUser);
//            session.getTransaction().commit();
//            if (factory!= null){
//                factory.close();

        }catch (Exception e){
            e.printStackTrace();
        } finally{
        sessionFactoryUtils.shotdown();
    }
    }
}
