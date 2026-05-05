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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArenaTestStudent {

    private Arena arena;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        arena = new Arena("Blue", 67.67, 41.41, "images/arena.png");
    }

    // ===== GETTER TESTS =====
    @Test
    public void testGetColor() {
        assertEquals("Blue", arena.getColor());
    }

    @Test
    public void testGetLength() {
        assertEquals(67.67, arena.getLength());
    }

    @Test
    public void testGetWidth() {
        assertEquals(41.41, arena.getWidth());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/arena.png", arena.getImagePath());
    }

    // ===== toString TEST =====
    @Test
    public void testToString() {
        assertTrue(arena.toString().contains("Arena"));
    }
}
