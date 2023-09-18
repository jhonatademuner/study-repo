public class Student extends Person {

    private String mat;

//    ===========================================================

    public Student(String name, String regId, String mat) {
        super(name, regId);
        this.mat = mat;
    }

//    ===========================================================

    private String getMat() {
        return this.mat;
    }

    private void setMat(String mat) {
        this.mat = mat;
    }

//    ===========================================================

    public String toString() {
        return this.getName() + " (Matrícula: " + this.getMat() + ")";
    }
}
