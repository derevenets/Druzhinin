package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.Service.RoleService;
import ru.sapteh.Service.UserRoleService;
import ru.sapteh.Service.UserService;
import ru.sapteh.model.Role;
import ru.sapteh.model.User;
import ru.sapteh.model.UserRole;

public class Program {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Dao<Role, Integer> roleDao = new RoleService(factory);
        Dao<User, Integer> userDao = new UserService(factory);
        Dao<UserRole, Integer> userRoleDao = new UserRoleService(factory);

        User max = userDao.read(1);
        Role role = roleDao.read(3);
        UserRole userRole = userRoleDao.read(2);


        System.out.println(max);
        System.out.println("=================>");
        System.out.println(role);
        System.out.println("================================>");
        System.out.println(userRole);


        factory.close();
    }
}
