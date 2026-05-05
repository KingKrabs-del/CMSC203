

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LionTestStudent {

	private Lion lion;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
    	lion = new Lion("Simba", 67, "Lion", "Golden", "images/lion.png");
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
    	assertEquals("Simba", lion.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(67, lion.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("Lion", lion.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Golden", lion.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/lion.png", lion.getImagePath());
    }

    // ===== toString TEST =====
    @Test
    public void testToString() {
        String expected = "Lion --- Name: Simba, Age: 67, Species: Lion, Color: Golden";
        assertEquals(expected, lion.toString());
    }

    // ===== makeSound TEST =====
    @Test
    public void testMakeSound() {
    	lion.makeSound();
        assertTrue(outputStream.toString().contains("roar"));
    }

    // ===== move TEST =====
    @Test
    public void testMove() {
        lion.move();
        assertTrue(outputStream.toString().contains("runs"));
    }
}
