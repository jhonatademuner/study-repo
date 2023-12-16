import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager implements Savable {

    public Scanner input;
    public FileManager(){};

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

    public <T> void writeCsvFile(List<T> dataList, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            for (T dataObject : dataList){
                ArrayList<String> values = objectToArray(dataObject);
                myWriter.write(values.get(1) + "," + values.get(2) + "," + values.get(0) + "\n");
            }
            myWriter.close();
        } catch (IOException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private <T> ArrayList<String> objectToArray(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        ArrayList<String> values = new ArrayList<>();
        while (objClass != null) {
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                values.add(field.get(obj).toString());
            }
            objClass = objClass.getSuperclass();
        }
        return values;
    }
}
