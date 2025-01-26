package com.example.park_sure.contoller;

import com.example.park_sure.dto.GuestDetails;
import com.example.park_sure.service.GuestVehicleApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

@Autowired
    GuestVehicleApplicationService guestVehicleApplicationService;

    @PostMapping("/addGuestVehicle")
    public GuestDetails addGuestVehicle(@RequestBody GuestDetails guestDetails)
    {
     return guestVehicleApplicationService.addGuestVehicle(guestDetails);

    }



}
