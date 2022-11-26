package com.skwita.turtle.controller;

import com.skwita.turtle.model.Turtle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class MainController {
    private final Turtle turtle;
    @Autowired
    public MainController(Turtle turtle) {
        this.turtle = turtle;
    }

    @GetMapping("/")
    @ResponseBody
    public String main(@RequestBody String input) throws IOException {
        try {
            BufferedImage image = turtle.process(input.split("\"")[3]);
            File outputFile = new File("image.jpg");
            ImageIO.write(image, "jpg", outputFile);
            return outputFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }
}
