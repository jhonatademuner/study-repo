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

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public TimeDate getSentDate() {
        return this.sentDate;
    }

    public void setSentDate(TimeDate deadline) {
        this.sentDate = deadline;
    }

    public int getExecTime() {
        return this.execTime;
    }

    public void setExecTime(int execTime) {
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