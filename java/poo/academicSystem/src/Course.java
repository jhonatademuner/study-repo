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

    private void printStudentGrades(Student student) {
       for (int i = 0; i < this.evaluations.length; i++) {
              System.out.println(this.evaluations[i].);
       }


    }



    public void averages() {
        System.out.println("Médias da Turma " + this.name + " :");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + " : " + evaluations[i].getGrades());
        }
        System.out.println("Média da Turma : " + "MEDIA DA TURMA (DUVIDA QUANTO AO FORMATO DO ARRAY DE AVALIACOES)");
    }
}
