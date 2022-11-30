package com.skwita.turtle;

import com.skwita.turtle.model.Turtle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

@SpringBootTest
class TurtleApplicationTests {
	Turtle turtle = new Turtle();
	Method fillArrayMethod = getMethodByName("fillArray", String.class);

	private Method getMethodByName(String name, Class<?> args) {
		try {
			Method method = Turtle.class.getDeclaredMethod(name, args);
			method.setAccessible(true);
			return method;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}
	}

	private char[][] getField() {
		try {
			Field field = Turtle.class.getDeclaredField("field");
			field.setAccessible(true);
			return (char[][]) field.get(turtle);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testArrayGeneration() throws InvocationTargetException, IllegalAccessException {
		String inp = "R+>>>";
		fillArrayMethod.invoke(turtle, inp);
		Assertions.assertEquals('-', Objects.requireNonNull(getField())[0][0]);
		Assertions.assertEquals('R', getField()[0][1]);
		Assertions.assertEquals('R', getField()[0][2]);
		Assertions.assertEquals('R', getField()[0][3]);
		for (int i = 2; i < 64; i++) {
			for (int j = 2; j < 64; j++) {
				Assertions.assertEquals('-', getField()[i][j]);
			}
		}
	}

	@Test
	void coloringTest() throws InvocationTargetException, IllegalAccessException {
		String inp = "+R>G>B>";
		fillArrayMethod.invoke(turtle, inp);
		Assertions.assertEquals('-', Objects.requireNonNull(getField())[0][0]);
		Assertions.assertEquals('R', getField()[0][1]);
		Assertions.assertEquals('G', getField()[0][2]);
		Assertions.assertEquals('B', getField()[0][3]);
		for (int i = 2; i < 64; i++) {
			for (int j = 2; j < 64; j++) {
				Assertions.assertEquals('-', getField()[i][j]);
			}
		}
	}

	@Test
	void movementTest() throws InvocationTargetException, IllegalAccessException {
		String inp = "+R>V<^";
		fillArrayMethod.invoke(turtle, inp);
		Assertions.assertEquals('R', Objects.requireNonNull(getField())[0][0]);
		Assertions.assertEquals('R', getField()[0][1]);
		Assertions.assertEquals('R', getField()[1][0]);
		Assertions.assertEquals('R', getField()[1][1]);
		for (int i = 2; i < 64; i++) {
			for (int j = 2; j < 64; j++) {
				Assertions.assertEquals('-', getField()[i][j]);
			}
		}
	}

	@Test
	void imageCheck() {
		String inp = "R>G>B>";
		BufferedImage result = turtle.process(inp);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Assertions.assertEquals(Color.BLACK, new Color(result.getRGB(j, i)));
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 10; j < 20; j++) {
				Assertions.assertEquals(Color.RED, new Color(result.getRGB(j, i)));
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 20; j < 30; j++) {
				Assertions.assertEquals(Color.GREEN, new Color(result.getRGB(j, i)));
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 30; j < 40; j++) {
				Assertions.assertEquals(Color.BLUE, new Color(result.getRGB(j, i)));
			}
		}
	}
}
