/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 4/20/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesFileIO {

    // Reads numbers from a file and stores them in a ragged 2D array
    public static double[][] readSalesData(String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner input = new Scanner(file);

        ArrayList<double[]> rows = new ArrayList<>();

        while (input.hasNextLine()) {

            String line = input.nextLine().trim();

            if (!line.isEmpty()) {

                String[] values = line.split("\\s+");

                double[] row = new double[values.length];

                for (int i = 0; i < values.length; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }

                rows.add(row);
            }
        }

        input.close();

        double[][] data = new double[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
    }

    // Writes totals, averages, and other results to an output file
    public static void writeSummary(String filename, double[][] data) throws IOException {

        PrintWriter output = new PrintWriter(new File(filename));

        output.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        output.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        output.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        output.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));

        for (int row = 0; row < data.length; row++) {
            output.printf("Row %d total: %.2f%n",
                    row,
                    SalesDataUtility.getRowTotal(data, row));
        }

        int maxColumns = SalesDataUtility.getLargestColumnCount(data);

        for (int col = 0; col < maxColumns; col++) {
            output.printf("Column %d total: %.2f%n",
                    col,
                    SalesDataUtility.getColumnTotal(data, col));
        }

        output.close();
    }
}
