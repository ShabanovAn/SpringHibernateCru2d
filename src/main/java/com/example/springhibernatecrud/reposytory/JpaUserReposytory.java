package com.example.springhibernatecrud.reposytory;

import com.example.springhibernatecrud.config.JPAConfig;
import com.example.springhibernatecrud.model.JpaUser;
import com.example.springhibernatecrud.model.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@AllArgsConstructor
public class JpaUserReposytory {
    @PersistenceContext//Достает обькт
            EntityManager entityManager;

    @Transactional
    public JpaUser addJpa(JpaUser jpaUser) {
        entityManager.persist(jpaUser);
        return jpaUser;
    }

    public List<JpaUser> getAllJpa() {
        return entityManager.
                createNativeQuery("select * from JpaUser", JpaUser.class).getResultList();
    }

    @Transactional
    public void deleteJpaUser(int id) {
        JpaUser jpaUser = entityManager.find(JpaUser.class, id);
        entityManager.remove(jpaUser);
    }

    @Transactional
    public JpaUser getJpaUserId(int id) {
        JpaUser jpaUser = entityManager.find(JpaUser.class, id);
        return jpaUser;
    }

    @Transactional
    public JpaUser updateJpaUser(JpaUser jpaUser, int id) {
        JpaUser jpaUserOld = entityManager.find(JpaUser.class, id);
        jpaUserOld.setFirst_name(jpaUser.getFirst_name());
        jpaUserOld.setLast_name(jpaUser.getLast_name());
        jpaUserOld.setEmail(jpaUser.getEmail());
        return entityManager.merge(jpaUserOld);
    }









}
