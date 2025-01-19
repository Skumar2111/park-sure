package com.example.park_sure.persistance;

import com.example.park_sure.dto.user_registration;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRegistrationImpl implements UserRegistrationDAO{

    EntityManager entityManager;

    public UserRegistrationImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(user_registration userRegistration) {

        entityManager.persist(userRegistration);

    }

    public user_registration get(String user_id)
    {
        user_registration userRegistration = entityManager.getReference(user_registration.class,user_id);
        return  userRegistration;
    }
}
