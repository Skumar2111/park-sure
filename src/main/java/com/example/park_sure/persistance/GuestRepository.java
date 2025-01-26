package com.example.park_sure.persistance;

import com.example.park_sure.dto.GuestDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<GuestDetails,String> {

}
