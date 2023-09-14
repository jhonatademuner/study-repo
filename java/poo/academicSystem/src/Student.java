public class Student extends Person {

    private String mat;

//    ===========================================================

    public Student(String name, String cpf, String mat) {
        super(name, cpf);
        this.mat = mat;
    }

//    ===========================================================

    private String getMat() {
        return mat;
    }

    private void setMat(String mat) {
        this.mat = mat;
    }

//    ===========================================================

    public String toString(){
        return this.getName() + " (Matrícula: " + this.getMat() + ")";
    }

}
