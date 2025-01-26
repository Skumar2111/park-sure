package com.example.park_sure.persistance;

import com.example.park_sure.dto.user_registration;

import java.util.List;

public interface UserRegistrationDAO {

    void save(user_registration userRegistration);

    user_registration get(String user_id);

    List<user_registration> filter(String user_name);

    user_registration updateUser(user_registration userRegistration);

    void deleteUser(String user_id);
}
