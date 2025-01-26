package com.example.park_sure.service;

import com.example.park_sure.dto.GuestDetails;
import com.example.park_sure.persistance.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.Random;

public class GuestVehicleApplicationService {

    @Autowired
    GuestRepository guestRepository;

    public GuestDetails addGuestVehicle(GuestDetails guestDetails)
    {
        if(null == guestDetails.getTime())
        {
            guestDetails.setTime(LocalTime.now());
        }

        guestDetails.setTicketNumber(generateTicket());

        guestRepository.save(guestDetails);

        return guestDetails;
    }

    private String generateTicket() {
        Random random = new Random();
        String ticketId = "PS-T"+random.nextLong(100L,5000000L);
        return ticketId;
    }


}
