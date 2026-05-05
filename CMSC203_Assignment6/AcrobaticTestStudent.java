import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcrobaticTestStudent {

    private Acrobatic acrobatic;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        acrobatic = new Acrobatic("Ballerina Cappuccian", 67, 41, "Dancer", "images/acrobatic.png");
    }

    @Test
    public void testGetName() {
        assertEquals("Ballerina Cappuccian", acrobatic.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(67, acrobatic.getAge());
    }

    @Test
    public void testGetYearsWorked() {
        assertEquals(41, acrobatic.getYearsWorked());
    }

    @Test
    public void testGetJob() {
        assertEquals("Dancer", acrobatic.getJob());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/acrobatic.png", acrobatic.getImagePath());
    }

    @Test
    public void testToString() {
        assertTrue(acrobatic.toString().contains("Acrobatic"));
    }
}
