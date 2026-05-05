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
        String expected = "\nBuilding Type: Arena \nColor: Red \nSize: 100.0 x 50.0\n";
        assertEquals(expected, arena.toString());
    }
}
