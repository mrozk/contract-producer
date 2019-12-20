package com.example.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class MessageController {

    @Autowired
    MessagingService service;

    @GetMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        service.sendFoo(what);
    }
}
