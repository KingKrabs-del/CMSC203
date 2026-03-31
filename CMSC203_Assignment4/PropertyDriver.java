/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */
public class PropertyDriver {
    public static void main(String[] args) {
        ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789");

        Property p1 = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        Property p2 = new Property("Apt 2", "Rockville", 1500.0, "Carol");
        Property p3 = new Property("Apt 3", "Silver Spring", 1800.0, "David");

        mc.addProperty(p1);
        mc.addProperty(p2);
        mc.addProperty(p3);

        System.out.println(mc);

        ManagementCompany copied = new ManagementCompany(mc);
        System.out.println("\nCopied Company:");
        System.out.println(copied);
    }
}
