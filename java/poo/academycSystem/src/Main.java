import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe principal
 *
 * @author Hilario Seibel Junior
 */

public class Main {

    private static void loadData(AcademicSys s){
        FileManager fileManager = new FileManager();

        try {
            ArrayList<Student> students = Student.convertCsvToArrayList(fileManager.readCsvFile("students.txt"));
            ArrayList<Professor> professors = Professor.convertCsvToArrayList(fileManager.readCsvFile("professors.txt"));

            s.setStudents(students);
            s.setProfessors(professors);
        } catch (NullPointerException e) {
            System.out.println("Arquivos locais não encontrados...");
        }
    }

    private static void saveData(AcademicSys s){
        FileManager fileManager = new FileManager();

        fileManager.writeCsvFile(s.getStudents(), "students.txt");
        fileManager.writeCsvFile(s.getProfessors(), "professors.txt");
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
                Collections.sort(s.getCourses());
                for (Course c : s.getCourses()) c.averages();
            }

            op = io.menu1();
        }

       saveData(s);
    }
}