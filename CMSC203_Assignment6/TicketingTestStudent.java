import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingTestStudent {
	
    private TicketingOffice to;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

	@BeforeEach
    public void setUp() {
		to = new TicketingOffice("Blue", 67, 41, "images/to.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }
    
    // ===== GETTER TESTS =====
    @Test
    public void testGetColor() {
        assertEquals("Blue", to.getColor());
    }

    @Test
    public void testGetLength() {
        assertEquals(67, to.getLength());
    }

    @Test
    public void testGetWidth() {
        assertEquals(41, to.getWidth());
    }

    // ===== toString TEST =====
    @Test
    public void testToString() {
//    	String expected = "Ticketing Office --- Building Type: Ticketing Office, Color: Blue, Length: 67, Width: 41";
//    	assertEquals(expected, to.toString());
    	assertTrue(to.toString().contains("Ticketing"));
     }
}
