/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 2/20/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */
public class SalesDataUtility {

    // Adds up all values in the ragged array
    public static double getTotal(double[][] data) {
        double total = 0.0;

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                total += data[row][col];
            }
        }

        return total;
    }

    // Finds the average of all numbers in the array
    public static double getAverage(double[][] data) {
        double total = 0.0;
        int count = 0;

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                total += data[row][col];
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return total / count;
    }

    // Adds up all values in one specific row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;

        for (int col = 0; col < data[row].length; col++) {
            total += data[row][col];
        }

        return total;
    }

    // Adds up values in one column (skips rows that don't have that column)
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;

        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length) {
                total += data[row][col];
            }
        }

        return total;
    }

    // Finds the highest value in a row
    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];

        for (int col = 1; col < data[row].length; col++) {
            if (data[row][col] > highest) {
                highest = data[row][col];
            }
        }

        return highest;
    }

    // Finds the lowest value in a row
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];

        for (int col = 1; col < data[row].length; col++) {
            if (data[row][col] < lowest) {
                lowest = data[row][col];
            }
        }

        return lowest;
    }

    // Finds the highest number in the whole array
    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] > highest) {
                    highest = data[row][col];
                }
            }
        }

        return highest;
    }

    // Finds the lowest number in the whole array
    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] < lowest) {
                    lowest = data[row][col];
                }
            }
        }

        return lowest;
    }

    // Finds the largest number of columns in the ragged array
    public static int getLargestColumnCount(double[][] data) {
        int maxColumns = 0;

        for (int row = 0; row < data.length; row++) {
            if (data[row].length > maxColumns) {
                maxColumns = data[row].length;
            }
        }

        return maxColumns;
    }
}
