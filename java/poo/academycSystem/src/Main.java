import java.util.ArrayList;

/**
 * Classe principal
 *
 * @author Hilario Seibel Junior
 */

public class Main {

    private static void loadData(AcademicSys s){
        CsvReader csvReader = new CsvReader();

        ArrayList<Student> students = Student.convertCsvToArrayList(csvReader.readCsvFile("students.txt"));
        ArrayList<Professor> professors = Professor.convertCsvToArrayList(csvReader.readCsvFile("professors.txt"));

        s.setStudents(students);
        s.setProfessors(professors);
    }

    private static void saveData(AcademicSys s){
        CsvWriter csvWriter = new CsvWriter();

        csvWriter.writeCsvFile(s.getStudents(), "students.txt");
        csvWriter.writeCsvFile(s.getProfessors(), "professors.txt");
    }

    public static void main(String[] args) {
        Entrada io = new Entrada();
        AcademicSys s = new AcademicSys();

        loadData(s);

        int op = io.menu1();

        while (op != 0) {
            if (op == 1) {
                io.cadProf(s);
            }
            if (op == 2) {
                io.cadAluno(s);
            }
            if (op == 3) {
                io.cadTurma(s);
            }
            if (op == 4) {
                for (Course c : s.getCourses()) c.averages();
            }

            op = io.menu1();
        }

       saveData(s);
    }
}