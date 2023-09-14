public class Professor extends Person {

    private double salary;

//    ===========================================================

    public Professor(String name, String email, double salary) {
        super(name, email);
        this.salary = salary;
    }

//    ===========================================================

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
