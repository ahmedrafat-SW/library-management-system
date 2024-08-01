package com.dev.librarymanagementsystem.dao;

import com.dev.librarymanagementsystem.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User, Long> {

    public UserDao(){
        super(User.class);
    }


    public User getUserByName(String username){
        EntityManager entityManager = getEntityManager();

        Query query = entityManager.createQuery("select u from User u where u.userName =: name", User.class);
        query.setParameter("name", username);

        return (User) query.getSingleResult();
    }
}
