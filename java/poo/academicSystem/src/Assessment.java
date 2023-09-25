public class Assessment extends Evaluation {

    private int estimateTime;
    private StudentAssessment[] grades;

//    ===========================================================

    public Assessment(String name, TimeDate applicationDate, double value, int estimateTime, StudentAssessment[] grades) {
        super(name, applicationDate, value);
        this.estimateTime = estimateTime;
        this.grades = grades;
    }

//    ===========================================================

    private int getEstimateTime() {
        return this.estimateTime;
    }

    private void setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
    }

    public StudentAssessment[] getGrades() {
        return this.grades;
    }

    private void setGrades(StudentAssessment[] grades) {
        this.grades = grades;
    }

//    ===========================================================

    public double grade(int index) {
        return this.grades[index].totalGrades(this.getApplicationDate(), this.getEstimateTime(), this.getValue());
    }

}
