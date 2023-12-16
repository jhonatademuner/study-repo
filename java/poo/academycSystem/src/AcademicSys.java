import java.util.ArrayList;
import java.util.List;

public class AcademicSys {

    private List<Professor> professors;

    private List<Student> students;

    private List<Course> courses;

//    ===========================================================

    public AcademicSys() {
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

//    ===========================================================

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }

//    ===========================================================

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public Professor findProfessor(String regID) {
        for (Professor p : professors) {
            if (p.getRegId().equals(regID)) return p;
        }
        return null;
    }

    public Student findStudent(String mat) {
        for (Student s : students) {
            if (s.getMat().equals(mat)) return s;
        }
        return null;
    }

    public void printProfessors() {
        System.out.println("Professores cadastrados:");
        for (Professor p : professors) {
            System.out.println("* " + p);
        }
    }

    public void printStudents() {
        System.out.println("Alunos cadastrados:");
        for (Student s : students) {
            System.out.println("* " + s);
        }
    }
}
