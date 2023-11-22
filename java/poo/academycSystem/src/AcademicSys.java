import java.util.ArrayList;

public class AcademicSys {

    private ArrayList<Professor> professors;

    private ArrayList<Student> students;

    private ArrayList<Course> courses;

//    ===========================================================

    public AcademicSys() {
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

//    ===========================================================

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses){
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
