package com.skwita.turtle.model;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class Turtle {
    public BufferedImage process(String input) {
        return new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
    }
}
