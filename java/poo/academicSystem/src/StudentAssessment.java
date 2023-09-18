public class StudentAssessment {

    private Student student;
    private double grade;
    private Date sentDate;
    private int execTime;

//    ===========================================================

    public StudentAssessment(Student student, double grade, Date deadline, int execTime) {
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

    private Date getSentDate() {
        return this.sentDate;
    }

    private void setSentDate(Date deadline) {
        this.sentDate = deadline;
    }

    private int getExecTime() {
        return this.execTime;
    }

    private void setExecTime(int execTime) {
        this.execTime = execTime;
    }

//    ===========================================================

    public double totalGrades(Date deadline, int expectedTime, double value) {
        if (this.sentDate.later(deadline)) {
            return this.grade * 0.8;
        } else if ((this.grade == value) && (this.execTime <= expectedTime)) {
            return (this.grade + 2) % (value + 0.01);
        }
        return this.grade;
    }

}