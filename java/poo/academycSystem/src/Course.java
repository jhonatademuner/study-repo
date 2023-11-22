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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Evaluation[] getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Evaluation[] evaluations) {
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

        try {
            System.out.println("Média da turma: " + courseMean / students.length);
        } catch (ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
