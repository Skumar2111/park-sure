package com.example.park_sure.contoller;


import com.example.park_sure.dto.UserRegistrationDTO;
import com.example.park_sure.service.UserRegistrationApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    @Autowired
    UserRegistrationApplicationService userRegistrationApplicationService;

    @PostMapping(value = "/registerUser")
    public UserRegistrationDTO registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO)
    {
        userRegistrationApplicationService.registerUser(userRegistrationDTO);
        return userRegistrationDTO;
    }


    @GetMapping(value = "/getUser", params = "user_id")
    public UserRegistrationDTO getUser(String user_id)
    {
        return userRegistrationApplicationService.getUserDetails(user_id);
    }


}
