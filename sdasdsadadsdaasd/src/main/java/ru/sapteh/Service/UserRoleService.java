package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.UserRole;

import java.util.List;


public class UserRoleService implements Dao<UserRole, Integer> {
    final SessionFactory factory;

    public UserRoleService(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public void create(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(userRole);
            session.getTransaction().commit();

        }

    }

    @Override
    public UserRole read(Integer integer) {
        try(Session session = factory.openSession()){
            UserRole userRole = session.get(UserRole.class, integer);
            return userRole;
        }
    }

    @Override
    public List<UserRole> readAll() {
        try(Session session = factory.openSession()){
            Query<UserRole> result = session.createQuery("FROM User_role");
            return result.getResultList();
        }

    }

    @Override
    public void update(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(userRole);
            session.getTransaction().commit();

        }

    }

    @Override
    public void delete(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(userRole);
            session.getTransaction().commit();
        }

    }
}
