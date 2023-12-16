import java.util.ArrayList;
import java.util.List;

public class Assessment extends Evaluation {

    private int estimateTime;
    private List<StudentAssessment> grades;

//    ===========================================================

    public Assessment(String name, TimeDate applicationDate, double value, int estimateTime, ArrayList<StudentAssessment> grades) {
        super(name, applicationDate, value);
        this.estimateTime = estimateTime;
        this.grades = grades;
    }

//    ===========================================================

    public int getEstimateTime() {
        return this.estimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
    }

    public List<StudentAssessment> getGrades() {
        return this.grades;
    }

    public void setGrades(List<StudentAssessment> grades) {
        this.grades = grades;
    }

//    ===========================================================

    public double grade(int index) {
        return this.grades.get(index).totalGrades(this.getApplicationDate(), this.getEstimateTime(), this.getValue());
    }

    public void swapEvaluation(int i, int j) {
        StudentAssessment temp = grades.get(i);
        grades.set(i, grades.get(j));
        grades.set(j, temp);
    }
}
