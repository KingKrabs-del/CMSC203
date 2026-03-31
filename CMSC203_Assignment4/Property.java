/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    //Default constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
    }

    /**Parameterized constructor
     * @param propertyName property name
     * @param city city name
     * @param rentAmount monthly rent
     * @param owner owner name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    /**Copy constructor
     * @param other the property to copy
     */
    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**Returns the property information as a formatted string
     * @return property details
     */
    @Override
    public String toString() {
        return "Property Name: " + propertyName
                + ", City: " + city
                + ", Rent Amount: $" + rentAmount
                + ", Owner: " + owner;
    }
}
