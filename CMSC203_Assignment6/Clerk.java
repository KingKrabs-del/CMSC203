/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: This program allows users to manage a circus by adding and viewing animals, people, and buildings, 
 * searching and sorting animals, and generating tickets with different pricing and discounts.
 * Due: 05/04/2026
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
*/
public class Clerk extends Person {

    public Clerk(String name, int age, int yearsWorked, String job, String imagePath) {
        super(name, age, yearsWorked, job, imagePath);
    }

    @Override
    public String toString() {
        return "Clerk - " + super.toString();
    }
}
