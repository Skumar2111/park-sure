package com.example.park_sure.service;

import com.example.park_sure.dto.UserRegistrationDTO;
import com.example.park_sure.dto.user_registration;
import com.example.park_sure.persistance.UserRegistrationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;


public class UserRegistrationApplicationService {

    @Autowired
    UserRegistrationDAO userRegistrationDAO;

    public UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO)
    {
       user_registration user_registration = mapUserRegistrationDetails(userRegistrationDTO);

        try {
            userRegistrationDAO.save(user_registration);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally {
            userRegistrationDTO.setUser_id(user_registration.getUser_id());
        }
        return userRegistrationDTO;
    }


    public UserRegistrationDTO getUserDetails(String user_id)
    {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        try
        {
            user_registration userRegistration = userRegistrationDAO.get(user_id);
            if(userRegistration != null)
            {
               userRegistrationDTO  = mapUserRegistrationAPIResponse(userRegistration, userRegistrationDTO);

            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return userRegistrationDTO;
    }

    private UserRegistrationDTO mapUserRegistrationAPIResponse(user_registration userRegistration, UserRegistrationDTO userRegistrationDTO) {

        userRegistrationDTO.setUser_id(userRegistration.getUser_id());
        userRegistrationDTO.setUser_name(userRegistration.getUser_name());
        userRegistrationDTO.setEmail(userRegistration.getEmail());
        userRegistrationDTO.setMobile_number(userRegistration.getMobile_number());
        userRegistrationDTO.setRegistered_on(userRegistration.getRegistered_on());
        userRegistrationDTO.setVerified(userRegistration.isVerified());

        return userRegistrationDTO;

    }



    public user_registration mapUserRegistrationDetails(UserRegistrationDTO userRegistrationDTO) {

        user_registration userRegistration = new user_registration();

        userRegistration.setUser_id(generateID());
        userRegistration.setUser_name(userRegistrationDTO.getUser_name());
        userRegistration.setRegistered_on(userRegistrationDTO.getRegistered_on());
        userRegistration.setMobile_number(userRegistrationDTO.getMobile_number());
        userRegistration.setEmail(userRegistrationDTO.getEmail());
        userRegistration.setVerified(userRegistrationDTO.isVerified());

        return userRegistration;

    }

    private String generateID() {

        Random random = new Random();
        Long l = random.nextLong(1000,10000000);
        String userId = "PS_"+l.toString();

        return userId;

    }
}
