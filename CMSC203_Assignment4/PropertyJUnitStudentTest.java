/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * Description: The program lets the user add properties, view a list of all properties, and calculate the total rent collected from all properties.
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyJUnitStudentTest {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();

        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("", p.getOwner());
    }

    @Test
    public void testParameterizedConstructor() {
        Property p = new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork");

        assertEquals("Apt 67", p.getPropertyName());
        assertEquals("Silver Spring", p.getCity());
        assertEquals(1200.0, p.getRentAmount(), 0.001);
        assertEquals("JohnPork", p.getOwner());
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Apt 41", "Silver Spring", 1500.0, "TungSahur");
        Property copy = new Property(original);

        assertEquals(original.getPropertyName(), copy.getPropertyName());
        assertEquals(original.getCity(), copy.getCity());
        assertEquals(original.getRentAmount(), copy.getRentAmount(), 0.001);
        assertEquals(original.getOwner(), copy.getOwner());

        assertNotSame(original, copy);
    }

    @Test
    public void testSetters() {
        Property p = new Property();

        p.setPropertyName("Apt 01");
        p.setCity("Silver Spring");
        p.setRentAmount(1800.0);
        p.setOwner("TimCheese");

        assertEquals("Apt 01", p.getPropertyName());
        assertEquals("Silver Spring", p.getCity());
        assertEquals(1800.0, p.getRentAmount(), 0.001);
        assertEquals("TimCheese", p.getOwner());
    }

    @Test
    public void testToStringContainsInfo() {
        Property p = new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork");
        String result = p.toString();

        assertTrue(result.contains("Apt 67"));
        assertTrue(result.contains("Silver Spring"));
        assertTrue(result.contains("JohnPork"));
        assertTrue(result.contains("1200"));
    }
}
