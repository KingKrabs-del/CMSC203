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

public class ManagementCompanyJUnitStudentTest {

    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("Six-Seven Street", "123-45-6789");

        Property p1 = new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork");
        Property p2 = new Property("Apt 41", "Silver Spring", 1500.0, "TungSahur");
        Property p3 = new Property("Apt 01", "Silver Spring", 1800.0, "TimCheese");

        assertEquals(0, mc.addProperty(p1));
        assertEquals(1, mc.addProperty(p2));
        assertEquals(2, mc.addProperty(p3));

        assertEquals(3, mc.getPropertyCount());
        assertEquals(4500.0, mc.totalRent(), 0.001);
    }

    @Test
    public void testGetProperty() {
        ManagementCompany mc = new ManagementCompany("Six-Seven Street", "123-45-6789");
        Property p1 = new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork");

        mc.addProperty(p1);

        assertEquals("Apt 67", mc.getProperty(0).getPropertyName());
        assertEquals("Silver Spring", mc.getProperty(0).getCity());
        assertNull(mc.getProperty(-1));
        assertNull(mc.getProperty(5));
    }

    @Test
    public void testAddPropertyWhenFull() {
        ManagementCompany mc = new ManagementCompany("Six-Seven Street", "123-45-6789");

        mc.addProperty(new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork"));
        mc.addProperty(new Property("Apt 41", "Silver Spring", 1500.0, "TungSahur"));
        mc.addProperty(new Property("Apt 01", "Silver Spring", 1800.0, "TimCheese"));
        mc.addProperty(new Property("Apt 02", "Silver Spring", 1000.0, "Freddie"));
        mc.addProperty(new Property("Apt 03", "Silver Spring", 1100.0, "BallerinaCappucuccina"));

        int result = mc.addProperty(new Property("Apt 04", "Silver Spring", 1300.0, "Tralalerrotralla"));

        assertEquals(-1, result);
        assertEquals(5, mc.getPropertyCount());
    }

    @Test
    public void testCopyConstructor() {
        ManagementCompany mc = new ManagementCompany("Six-Seven Street", "123-45-6789");

        mc.addProperty(new Property("Apt 67", "Silver Spring", 1200.0, "JohnPork"));
        mc.addProperty(new Property("Apt 41", "Silver Spring", 1500.0, "TungSahur"));
        mc.addProperty(new Property("Apt 01", "Silver Spring", 1800.0, "TimCheese"));

        ManagementCompany copied = new ManagementCompany(mc);

        assertEquals(mc.getName(), copied.getName());
        assertEquals(mc.getTaxId(), copied.getTaxId());
        assertEquals(mc.getPropertyCount(), copied.getPropertyCount());
        assertEquals(mc.totalRent(), copied.totalRent(), 0.001);

        assertNotSame(mc.getProperty(0), copied.getProperty(0));
    }
}
