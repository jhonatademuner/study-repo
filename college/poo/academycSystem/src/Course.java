import java.util.List;

public class Course implements Comparable<Course>{

    private String name;
    private int year;
    private int semester;
    private Professor prof;
    private List<Student> students;
    private List<Evaluation> evaluations;


//    ===========================================================

    public Course(String name, int year, int semester, Professor prof, List<Student> students, List<Evaluation> evaluations) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
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

        this.sortStudentsByGrades();

        for (int i = 0; i < students.size(); i++) {
            double sum = 0;
            System.out.print(students.get(i) + ": ");
            for (Evaluation evaluation : evaluations) {
                System.out.print(evaluation.grade(i) + " ");
                sum += evaluation.grade(i);
            }
            sum = maxGrade(sum);
            System.out.println("= " + sum);
            courseMean += sum;
        }

        try {
            System.out.println("Média da turma: " + courseMean / students.size() + "\n");
        } catch (ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private double getStudentGrade(Student s){
        int index = this.students.indexOf(s);
        double sum = 0;
        for (Evaluation evaluation : evaluations) {
            sum += evaluation.grade(index);
        }
        return maxGrade(sum);
    }

    private void swapStudents(int i, int j){
        Student temp = this.students.get(i);
        this.students.set(i, this.students.get(j));
        this.students.set(j, temp);
        for (Evaluation evaluation : evaluations) {
            evaluation.swapEvaluation(i, j);
        }
    }

    public void sortStudentsByGrades() {
        int n = this.students.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (getStudentGrade(this.students.get(j)) == getStudentGrade(this.students.get(j + 1))) {
                    if (this.students.get(j).compareTo(this.students.get(j + 1)) < 0){
                        swapStudents(j, j+1);
                        swapped = true;
                    }
                } else if (getStudentGrade(this.students.get(j)) < getStudentGrade(this.students.get(j + 1))) {
                    swapStudents(j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    @Override
    public int compareTo(Course c) {
        if (this.year != c.getYear()) return this.year - c.getYear();
        else if (this.semester != c.getSemester()) return this.semester - c.getSemester();
        else if (!this.getName().equals(c.getName())) return this.name.compareTo(c.getName());
        return this.prof.compareTo(c.getProf());
    }
}

