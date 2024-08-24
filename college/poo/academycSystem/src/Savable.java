import java.util.List;

public interface Savable {

    String readCsvFile(String filePath);
    <T> void writeCsvFile(List<T> dataList, String filePath);

}
