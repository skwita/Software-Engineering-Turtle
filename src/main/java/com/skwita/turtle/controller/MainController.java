package com.skwita.turtle.controller;

import com.skwita.turtle.model.Turtle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final Turtle turtle;
    @Autowired
    public MainController(Turtle turtle) {
        this.turtle = turtle;
    }

    @GetMapping("/")
    public void main(@RequestBody String input) {
        turtle.process(input);
    }
}
