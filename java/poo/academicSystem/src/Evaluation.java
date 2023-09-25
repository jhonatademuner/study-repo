public class Evaluation {

    private String name;
    private TimeDate applicationDate;
    private double value;

//    ===========================================================

    public Evaluation(String name, TimeDate applicationDate, double value) {
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

    protected TimeDate getApplicationDate() {
        return this.applicationDate;
    }

    protected void setApplicationDate(TimeDate applicationDate) {
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


}
