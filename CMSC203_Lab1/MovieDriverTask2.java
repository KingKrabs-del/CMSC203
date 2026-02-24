package Lab1_CreateDrvire_st;
import java.util.Scanner;

/*
 * CMSC203 Lab 1 - Movie Driver (Task 2)
 * Name: Ishatta King
 * Section: <Your Section>
 *
 * Description:
 * This driver program prompts the user for a movie title, rating,
 * and the number of tickets sold, stores the values in a Movie object,
 * and prints the movie information using Movie's toString() method.
 */

public class MovieDriverTask2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String again;  // stores user response to continue looping

        do {
            // Create a new Movie object each loop iteration
            Movie movie = new Movie();

            // Read title
            System.out.print("Enter the title of a movie: ");
            String title = keyboard.nextLine();
            movie.setTitle(title);

            // Read rating
            System.out.print("Enter the movie's rating: ");
            String rating = keyboard.nextLine();
            movie.setRating(rating);

            // Read tickets sold
            System.out.print("Enter the number of tickets sold: ");
            int ticketsSold = keyboard.nextInt();
            movie.setSoldTickets(ticketsSold);

            // Clear the leftover newline from nextInt()
            keyboard.nextLine();

            // Print movie info
            System.out.println();
            System.out.println(movie.toString());
            System.out.println();

            // Ask user if they want to continue
            System.out.print("Do you want to enter another movie? (yes/no): ");
            again = keyboard.nextLine();

            System.out.println();

            // Continue while user says "yes" (case-insensitive)
        } while (again.equalsIgnoreCase("yes"));

        keyboard.close();
        System.out.println("Goodbye!");
    }
}
