package com.example.park_sure.config;

import com.example.park_sure.persistance.UserRegistrationDAO;
import com.example.park_sure.service.GuestVehicleApplicationService;
import com.example.park_sure.service.IUserRegistrationApplicationService;
import com.example.park_sure.service.UserRegistrationApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserRegistrationApplicationService userRegistrationApplicationService()
    {
        return new UserRegistrationApplicationService();
    }

    @Bean
    public GuestVehicleApplicationService guestVehicleApplicationService()
    {
        return new GuestVehicleApplicationService();
    }

}
