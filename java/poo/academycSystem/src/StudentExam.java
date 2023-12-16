import java.util.ArrayList;
import java.util.List;

public class StudentExam {

    private Student student;
    private List<Double> grades;

//    ===========================================================

    public StudentExam(Student student, ArrayList<Double> grades) {
        this.student = student;
        this.grades = grades;
    }

//    ===========================================================

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Double> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

//    ===========================================================

    double totalGrades() {
        double sum = 0;
        for (double grade : this.grades) {
            sum += grade;
        }
        return sum;
    }

}
