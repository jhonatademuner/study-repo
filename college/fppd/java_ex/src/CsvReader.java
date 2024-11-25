import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    // Static method to read values from a CSV file and return them as an int array
    public static int[] readCsvAsIntArray(String fileName) {
        int[] values = new int[0];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Parse the scientific notation value and cast it to int
                    double value = Double.parseDouble(line.trim());
                    // Resize the array and add the value (casting it to int)
                    if (index >= values.length) {
                        values = java.util.Arrays.copyOf(values, values.length + 1);
                    }
                    values[index++] = (int) value; // Cast double to int
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
}
