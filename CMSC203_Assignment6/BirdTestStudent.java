/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: This program allows users to manage a circus by adding and viewing animals, people, and buildings, 
 * searching and sorting animals, and generating tickets with different pricing and discounts.
 * Due: 05/04/2026
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
*/

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdTestStudent {

	private Bird bird;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        bird = new Bird("Tweety", 2, "Twitter", "Blue", "images/bird.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    // ===== GETTER TESTS =====
    @Test
    public void testGetName() {
        assertEquals("Tweety", bird.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(2, bird.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("Twitter", bird.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Blue", bird.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/bird.png", bird.getImagePath());
    }

    // ===== toString TEST =====
    @Test
    public void testToString() {
        String expected = "Bird --- Name: Tweety, Age: 2, Species: Twitter, Color: Blue";
        assertEquals(expected, bird.toString());
    }

    // ===== makeSound TEST =====
    @Test
    public void testMakeSound() {
        bird.makeSound();
        assertTrue(outputStream.toString().contains("tweets on twitter"));
    }

    // ===== move TEST =====
    @Test
    public void testMove() {
        bird.move();
        assertTrue(outputStream.toString().contains("flies"));
    }
}
