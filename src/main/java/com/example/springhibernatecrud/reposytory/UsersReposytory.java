package com.example.springhibernatecrud.reposytory;

import com.example.springhibernatecrud.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@AllArgsConstructor
public class UsersReposytory {
    SessionFactory sessionFactory;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public User add(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        }
        return user;
    }

    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From User")
                    .getResultList();
        }
    }


    public User getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            return user;
        }
    }

    @Transactional
    public void removeById(int id) {
//        User user = sessionFactory.getCurrentSession().get(User.class, id);
//        sessionFactory.getCurrentSession().delete(user);
//        sessionFactory.openSession().createQuery("DELETE User WHERE id = :id")
//               .setParameter("id", id)
//               .executeUpdate();
       Query query = sessionFactory.getCurrentSession().createQuery("DELETE User WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
//        return result;
    }

//    @Transactional
//    public User updateUser(User user, int id) {
//        User user1 = null;
//        try(Session session = sessionFactory.openSession()){
//            session.setFlushMode(FlushMode.AUTO);
//            session.beginTransaction();
//            try {
//                session.saveOrUpdate(user);
//                session.getTransaction().commit();
//            } catch (Exception ex) {
//                session.getTransaction().rollback();
//                throw RuntimeException(ex);
//            }
        }
//            session.beginTransaction().begin();
//            user1 = session.get(User.class, id);
//            user1.setId(user1.getId());
//            user1.setFirst_name(user.getFirst_name());
//            user1.setLast_name(user.getLast_name());
//            user1.setEmail(user.getEmail());
//            session.merge(user1);
//            session.getTransaction().commit();
           // session.save(user1);
            //session.evict(user1);


//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return user1;
//    }
//}

//    public void callProcedure(int id) {
//        try (Session session = sessionFactory.openSession()) {
//            String sql = "call getId(:id)";
//            Query query = session.createNativeQuery(sql).setParameter("id", id);
//             List<String> strings =  query.list();
//            System.out.println(strings);
//
//        }
//    }





