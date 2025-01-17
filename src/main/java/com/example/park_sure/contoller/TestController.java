package com.example.park_sure.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

@GetMapping("/")
public String testPage()
{
    return "Welcome , you are on test page for park-sure.";
}

}
