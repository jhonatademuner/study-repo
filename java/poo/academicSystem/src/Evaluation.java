public class Evaluation {

    private String name;
    private Date applicationDate;
    private double value;

//    ===========================================================

    public Evaluation(String name, Date applicationDate, double value) {
        this.name = name;
        this.applicationDate = applicationDate;
        this.value = value;
    }

//    ===========================================================

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Date getApplicationDate() {
        return this.applicationDate;
    }

    protected void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    protected double getValue() {
        return this.value;
    }

    protected void setValue(double value) {
        this.value = value;
    }

//    ===========================================================

    public double grade(int index) {
        return 0;
    }

    public Object getGrades() {
        return null;
    }
}
