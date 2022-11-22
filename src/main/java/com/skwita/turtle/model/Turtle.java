package com.skwita.turtle.model;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Arrays;

@Component
public class Turtle {
    private char[][] field = new char[64][64];

    public BufferedImage process(String input) {
        fillArray(input);
        return new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
    }

    private void fillArray(String input) {
        input = "R>R>R>G>G>GVBVBVBVBV<R<R<R";
        for (char[] row: field) {
            Arrays.fill(row, '-');
        }
        int curX = 0;
        int curY = 0;
        for (char aChar: input.toCharArray()) {
            switch (aChar) {
                case '>': curX += curX < 64 ? 1 : 0; break;
                case '<': curX -= curX > 0 ? 1 : 0; break;
                case 'V': curY += curY < 64 ? 1 : 0; break;
                case '^': curY -= curY > 0 ? 1 : 0; break;
                case 'R': field[curY][curX] = 'R'; break;
                case 'G': field[curY][curX] = 'G'; break;
                case 'B': field[curY][curX] = 'B'; break;
            }
        }
        System.out.println(Arrays.deepToString(field));
    }
}
