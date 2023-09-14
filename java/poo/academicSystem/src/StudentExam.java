public class StudentExam {

    private Student student;
    private double[] grades;

//    ===========================================================

    public StudentExam(Student student, double[] grades) {
        this.student = student;
        this.grades = grades;
    }

//    ===========================================================

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
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
