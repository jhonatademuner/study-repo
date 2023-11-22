import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReader {

    public Scanner input;
    public CsvReader() {}

    public String readCsvFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try {
            this.input = new Scanner(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }

        String nextLine;

        while (this.input.hasNextLine()) {
            nextLine = this.input.nextLine();
            content.append(nextLine).append("\n");
        }

        return content.toString();
    }
}
