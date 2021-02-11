package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Role;

import java.util.List;

public class RoleService implements Dao<Role, Integer> {
    final SessionFactory factory;

    public RoleService(SessionFactory factory){
        this.factory = factory;
    }

    public void create(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
    }

    public Role read(Integer integer) {
        try(Session session = factory.openSession()){
            Role role = session.get(Role.class, integer);
            return role;
        }

    }

    @Override
    public List<Role> readAll() {
        try(Session session = factory.openSession()){
            Query<Role> result = session.createQuery("FROM Role");
            return  result.getResultList();
        }

    }

    public void update(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();

        }

    }

    public void delete(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }

    }
}
