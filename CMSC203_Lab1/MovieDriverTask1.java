package Lab1_CreateDrvire_st;
import java.util.Scanner;

/*
 * CMSC203 Lab 1 - Movie Driver (Task 1)
 * Name: Ishatta King
 * Section: <Your Section>
 *
 * Description:
 * This driver program prompts the user for a movie title, rating,
 * and the number of tickets sold, stores the values in a Movie object,
 * and prints the movie information using Movie's toString() method.
 */

public class MovieDriverTask1 {

    public static void main(String[] args) {

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Create a new Movie object using the default constructor
        Movie movie = new Movie();

        // Prompt for and read the movie title
        System.out.print("Enter the title of a movie: ");
        String title = keyboard.nextLine();
        movie.setTitle(title);

        // Prompt for and read the movie rating
        System.out.print("Enter the movie's rating: ");
        String rating = keyboard.nextLine();
        movie.setRating(rating);

        // Prompt for and read tickets sold (integer)
        System.out.print("Enter the number of tickets sold: ");
        int ticketsSold = keyboard.nextInt();
        movie.setSoldTickets(ticketsSold);

        // Print out the information using the movie's toString method
        System.out.println();
        System.out.println(movie.toString());

        keyboard.close();
    }
}
