/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */
public class ManagementCompany {
    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    /**Parameterized constructor
     * @param name company name
     * @param taxId company tax ID
     */
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = 0;
    }

    /**Copy constructor
     * @param other the management company to copy
     */
    public ManagementCompany(ManagementCompany other) {
        this.name = other.name;
        this.taxId = other.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = other.propertyCount;

        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    /**Return the property at the given index
     * @param index index in the array
     * @return property at index, or null if invalid
     */
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }
        return properties[index];
    }

    /**Adds a copy of the property to the array
     * @param p property to add
     * @return index where property was added, or -1 if full
     */
    public int addProperty(Property p) {
        if (propertyCount >= MAX_PROPERTIES) {
            return -1;
        }

        properties[propertyCount] = new Property(p);
        propertyCount++;
        return propertyCount - 1;
    }

    /**Calculates the total rent of all stored properties
     * @return total rent
     */
    public double totalRent() {
        double total = 0.0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    /**Return s a formatted summary of the company and all properties
     * @return formatted company information
     */
    @Override
    public String toString() {
        String result = "Management Company: " + name
                + "\nTax ID: " + taxId
                + "\n-------------------------\n";

        for (int i = 0; i < propertyCount; i++) {
            result += properties[i].toString() + "\n";
        }

        result += "-------------------------\n";
        result += "Total Rent: $" + totalRent();

        return result;
    }
}
