public abstract class Evaluation {

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeDate getApplicationDate() {
        return this.applicationDate;
    }

    public void setApplicationDate(TimeDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

//    ===========================================================

    public abstract double grade(int index);

    public abstract void swapEvaluation(int i, int j);


}
