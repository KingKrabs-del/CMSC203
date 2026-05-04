/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    // Default Constructor
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0;
        owner = "";
    }

    // Parameterized Constructor
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    // Copy Constructor
    public Property(Property other) {
        this(other.propertyName, other.city,other.rentAmount,other.owner);
    }

    // Getter methods
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    // Setter methods
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // toString
    @Override
    public String toString() {
        return "Property Name: " + propertyName + ", City: " + city + ", Owner: " + owner + ", Rent: $" + rentAmount;
    }
}
