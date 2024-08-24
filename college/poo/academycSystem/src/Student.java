import java.util.ArrayList;

public class Student extends Person implements Comparable<Student> {

    private String mat;

//    ===========================================================

    public Student(String name, String regId, String mat) {
        super(name, regId);
        this.mat = mat;
    }

//    ===========================================================

    public String getMat() {
        return this.mat;
    }

    private void setMat(String mat) {
        this.mat = mat;
    }

//    ===========================================================

    @Override
    public String toString() {
        return this.getName() + " (Matrícula: " + this.getMat() + ")";
    }

    public static ArrayList<Student> convertCsvToArrayList(String csvContent){
        ArrayList<Student> studentsList = new ArrayList<>();

        String[] lines = csvContent.split("\n");

        for (String line : lines) {
            String[] values = line.split(",");

            try {
                Student s = new Student(values[0], values[1], values[2]);
                studentsList.add(s);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        return studentsList;
    }

    @Override
    public int compareTo(Student s) {
        return s.getMat().compareTo(this.getMat());
    }
}
