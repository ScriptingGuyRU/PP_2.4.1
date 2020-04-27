package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public boolean addUser(User user) {
        if (validator(user)) {
            sessionFactory.getCurrentSession().save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void editUser(User user) {
         sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        String hql = "From User where name = :name and password = :password";
        return (User) sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("name",name)
                .setParameter("password",password)
                .uniqueResult();

    }

    @Override
    public User getUserByName(String name) {
        String hql = "select u From User u where u.name = :name";
        return (User) sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("name",name)
                .uniqueResult();
    }

    @Override
    public boolean validator(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE name=:name")
                .setParameter("name", user.getName())
                .list().size() == 0;
    }
}
