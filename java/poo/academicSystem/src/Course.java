public class Course {

    private String name;
    private int year;
    private int semester;
    private Professor prof;
    private Student[] students;
    private Evaluation[] evaluations;


//    ===========================================================

    public Course(String name, int year, int semester, Professor prof, Student[] students, Evaluation[] evaluations) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.prof = prof;
        this.students = students;
        this.evaluations = evaluations;
    }

//    ===========================================================

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private int getSemester() {
        return semester;
    }

    private void setSemester(int semester) {
        this.semester = semester;
    }

    private Professor getProf() {
        return prof;
    }

    private void setProf(Professor prof) {
        this.prof = prof;
    }

    private Student[] getStudents() {
        return students;
    }

    private void setStudents(Student[] students) {
        this.students = students;
    }

    private Evaluation[] getEvaluations() {
        return evaluations;
    }

    private void setEvaluations(Evaluation[] evaluations) {
        this.evaluations = evaluations;
    }



//    ===========================================================

    public String toString(){
        return this.name + " (" + this.year + "/" + this.semester + ")";
    }

    private double maxGrade(double sum){
        return Math.min(sum, 100.0);
    }

    public void averages() {
        double courseMean = 0;

        System.out.println("Médias da Turma " + this + " :");
        for (int i = 0; i < students.length; i++) {
            double sum = 0;
            System.out.print(students[i] + ": ");
            for (Evaluation evaluation : evaluations) {
                System.out.print(evaluation.grade(i) + " ");
                sum += evaluation.grade(i);
            }
            sum = maxGrade(sum);
            System.out.println("= " + sum);
            courseMean += sum;
        }
        System.out.println("Média da turma: " + courseMean / students.length);
    }
}
