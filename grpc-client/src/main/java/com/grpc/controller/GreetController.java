package com.grpc.controller;

import com.grpc.client.GreetClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {

    private final GreetClient greetClient;

    public GreetController(GreetClient greetClient) {
        this.greetClient = greetClient;
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        return greetClient.sendGreeting(name);
    }
}
