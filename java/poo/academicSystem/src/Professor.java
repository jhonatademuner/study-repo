public class Professor extends Person {

    private double salary;

//    ===========================================================

    public Professor(String name, String regId, double salary) {
        super(name, regId);
        this.salary = salary;
    }

//    ===========================================================

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
