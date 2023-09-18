public class Exam extends Evaluation {

    private int QuestionsNum;
    private StudentExam[] grades;

//    ===========================================================

    public Exam(String name, Date applicationDate, double value, int questionsNum, StudentExam[] grades) {
        super(name, applicationDate, value);
        this.QuestionsNum = questionsNum;
        this.grades = grades;
    }

//    ===========================================================

    private int getQuestionsNum() {
        return this.QuestionsNum;
    }

    private void setQuestionsNum(int questionsNum) {
        this.QuestionsNum = questionsNum;
    }

    public StudentExam[] getGrades() {
        return this.grades;
    }

    public void setGrades(StudentExam[] grades) {
        this.grades = grades;
    }

//    ===========================================================

    public double grade(int index) {
        return this.grades[index].totalGrades();
    }

}
