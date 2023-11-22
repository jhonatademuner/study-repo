import java.lang.reflect.Field;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class CsvWriter {

    CsvWriter(){};

    public <T> void writeCsvFile(ArrayList<T> dataList, String filePath) {
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
