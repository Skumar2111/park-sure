package com.example.park_sure.persistance;

import com.example.park_sure.dto.user_registration;

public interface UserRegistrationDAO {

    void save(user_registration userRegistration);

    user_registration get(String user_id);

    void remove(String user_id);
}
