package com.example.park_sure.persistance;

import com.example.park_sure.dto.user_registration;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<user_registration> filter(String user_name) {

        TypedQuery<user_registration> user_registrationTypedQuery = entityManager.createQuery(" from user_registration where user_name=:theData",
                user_registration.class);

        user_registrationTypedQuery.setParameter("theData",user_name);

        return user_registrationTypedQuery.getResultList();

    }

    @Override
    @Transactional
    public user_registration updateUser(user_registration userRegistrationParam) {

        user_registration user_registration = entityManager.find(com.example.park_sure.dto.user_registration.class,userRegistrationParam.getUser_id());

        user_registration.setUser_name(userRegistrationParam.getUser_name());
        user_registration.setEmail(userRegistrationParam.getEmail());
        user_registration.setMobile_number(userRegistrationParam.getMobile_number());
        user_registration.setRegistered_on(userRegistrationParam.getRegistered_on());

        entityManager.merge(user_registration);

        return user_registration;
    }

    @Override
    @Transactional
    public void deleteUser(String user_id) {

        user_registration userRegistration = entityManager.getReference(user_registration.class,user_id);
        entityManager.remove(userRegistration);

    }
}
