package com.skwita.turtle.controller;

import com.skwita.turtle.model.Turtle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class MainController {
    private final Turtle turtle;
    @Autowired
    public MainController(Turtle turtle) {
        this.turtle = turtle;
    }

    public BufferedImage main(@RequestBody String input) {
        return turtle.process(input);
    }
}
