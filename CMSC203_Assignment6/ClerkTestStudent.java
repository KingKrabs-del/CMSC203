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

public class ClerkTestStudent {

    private Clerk clerk;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        clerk = new Clerk("A-Students", 67, 41, "Front Desk", "images/clerk.png");
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    // ===== GETTER TESTS =====
    @Test
    public void testGetName() {
        assertEquals("A-Students", clerk.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(67, clerk.getAge());
    }

    @Test
    public void testGetYearsWorked() {
        assertEquals(41, clerk.getYearsWorked());
    }

    @Test
    public void testGetJob() {
        assertEquals("Front Desk", clerk.getJob());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/clerk.png", clerk.getImagePath());
    }
    
    // ===== toString TEST =====
    @Test
    public void testToString() {
        assertTrue(clerk.toString().contains("Clerk"));
    }
}
