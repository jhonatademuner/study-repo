public class StudentAssessment {

    private Student student;
    private double grade;
    private TimeDate sentDate;
    private int execTime;

//    ===========================================================

    public StudentAssessment(Student student, double grade, TimeDate deadline, int execTime) {
        this.student = student;
        this.grade = grade;
        this.sentDate = deadline;
        this.execTime = execTime;
    }

//    ===========================================================

    private Student getStudent() {
        return this.student;
    }

    private void setStudent(Student student) {
        this.student = student;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private TimeDate getSentDate() {
        return this.sentDate;
    }

    private void setSentDate(TimeDate deadline) {
        this.sentDate = deadline;
    }

    private int getExecTime() {
        return this.execTime;
    }

    private void setExecTime(int execTime) {
        this.execTime = execTime;
    }

//    ===========================================================

    public double totalGrades(TimeDate deadline, int expectedTime, double value) {
        if (this.sentDate.later(deadline)) {
            return this.grade * 0.8;
        } else if ((this.grade == value) && (this.execTime <= expectedTime)) {
            return this.grade + 2;
        }
        return this.grade;
    }

}