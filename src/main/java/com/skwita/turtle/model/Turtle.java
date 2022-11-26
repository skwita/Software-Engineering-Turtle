package com.skwita.turtle.model;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

@Component
public class Turtle {
    private char[][] field = new char[64][64];

    public BufferedImage process(String input) {
        fillArray(input);
        BufferedImage result = drawImage();
        return result;
    }

    private void fillArray(String input) {
        for (char[] row : field) {
            Arrays.fill(row, '-');
        }
        char curColor = 'R';
        boolean isDrawing = true;
        int curX = 0;
        int curY = 0;
        for (char aChar : input.toCharArray()) {
            switch (aChar) {
                case '>':
                    curX += curX < 64 ? 1 : 0;
                    if (isDrawing) {
                        field[curY][curX] = curColor;
                    }
                    break;
                case '<':
                    curX -= curX > 0 ? 1 : 0;
                    if (isDrawing) {
                        field[curY][curX] = curColor;
                    }
                    break;
                case 'V':
                    curY += curY < 64 ? 1 : 0;
                    if (isDrawing) {
                        field[curY][curX] = curColor;
                    }
                    break;
                case '^':
                    curY -= curY > 0 ? 1 : 0;
                    if (isDrawing) {
                        field[curY][curX] = curColor;
                    }
                    break;
                case 'R':
                    curColor = 'R';
                    break;
                case 'G':
                    curColor = 'G';
                    break;
                case 'B':
                    curColor = 'B';
                    break;
                case '+':
                    isDrawing = true;
                    break;
                case '-':
                    isDrawing = false;
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }

    private BufferedImage drawImage() {
        BufferedImage image = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
        Graphics2D imageGraphics = image.createGraphics();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                switch (field[j][i]) {
                    case 'R':
                        imageGraphics.setColor(Color.RED);
                        imageGraphics.fillRect(i * 10, j * 10, 10, 10);
                        break;
                    case 'G':
                        imageGraphics.setColor(Color.GREEN);
                        imageGraphics.fillRect(i * 10, j * 10, 10, 10);
                        break;
                    case 'B':
                        imageGraphics.setColor(Color.BLUE);
                        imageGraphics.fillRect(i * 10, j * 10, 10, 10);
                        break;
                    default:
                        imageGraphics.setColor(Color.BLACK);
                        imageGraphics.fillRect(i * 10, j * 10, 10, 10);
                        break;
                }
            }
        }
        return image;
    }
}
