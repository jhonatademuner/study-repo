public class AcademicSys {


    private int professorsNum;
    private int studentsNum;
    private Professor[] professors;
    private Student[] students;

//    ===========================================================

    public AcademicSys() {
        this.professorsNum = 0;
        this.studentsNum = 0;
        this.professors = new Professor[100];
        this.students = new Student[1000];
    }


//    ===========================================================
    private int getProfessorsNum() {
        return professorsNum;
    }

    private int getStudentsNum() {
        return studentsNum;
    }

    private Professor[] getProfessors() {
        return professors;
    }

    private Student[] getStudents() {
        return students;
    }

//    ===========================================================

    public void addProfessor(Professor p){
        professors[professorsNum] = p;
        professorsNum += 1;
    }

    public void addStudent(Student s){
        students[studentsNum] = s;
        studentsNum += 1;
    }

    public Professor findProfessor(String regID){
        int i = 0;
        while(i < professorsNum){
            if (professors[i].getRegId().equals(regID)){
                return professors[i];
            }
            i++;
        }
        return null;
    }

    public Student findStudent(String mat){
        int i = 0;
        while(i < studentsNum){
            if (students[i].getMat().equals(mat)){
                return students[i];
            }
            i++;
        }
        return null;
    }

    public void printProfessors(){
        System.out.println("Professores cadastrados:");
        for (int i = 0; i < professorsNum; i++){
            System.out.println("* " + professors[i]);
        }
    }

    public void printStudents(){
        System.out.println("Alunos cadastrados:");
        for (int i = 0; i < studentsNum; i++){
            System.out.println("* " + students[i]);
        }
    }

}
