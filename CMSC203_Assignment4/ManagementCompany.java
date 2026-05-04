/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * Description: The program lets the user add properties, view a list of all properties, and calculate the total rent collected from all properties.
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
 */
public class ManagementCompany {
	
    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    // Parameterized Constructor
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = 0;
    }

    // Copy Constructor
    public ManagementCompany(ManagementCompany other) {
    	// Learned from Page 8-31 in chapter 8 slides
        this(other.name, other.taxId);

        for (int i = 0; i < other.propertyCount; i++) {
            properties[i] = new Property(other.properties[i]);
        }

        propertyCount = other.propertyCount;
    }

    //Adds a property and returns its index, or -1 if full
    public int addProperty(Property property) {
        if (property == null) {
            return -1;
        }

        if (propertyCount >= MAX_PROPERTIES) {
            return -1;
        }

        properties[propertyCount] = new Property(property);
        propertyCount++;

        return propertyCount - 1;
    }

    // Calculates and returns the total rent of all properties
    public double totalRent() {
        double total = 0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public int getPropertyCount() {
        return propertyCount;
    }
    
    // Returns the property at the given index or null if invalid
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }

        return properties[index];
    }

    public String toString() {
        String result = "Management Company: " + name + "\nID: " + taxId + "\nProperties:\n";

        for (Property props : properties) {
        	if(props != null) {
        		result += props + "\n";
        	}
        }

        result += "Total Rent: $" +  totalRent();

        return result;
    }
}
