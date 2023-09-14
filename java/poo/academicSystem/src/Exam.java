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
        return QuestionsNum;
    }

    private void setQuestionsNum(int questionsNum) {
        this.QuestionsNum = questionsNum;
    }

    private StudentExam[] getGrades() {
        return grades;
    }

    private void setGrades(StudentExam[] grades) {
        this.grades = grades;
    }

//    ===========================================================

    public double grade(int index) {
        return this.grades[index].totalGrades();
    }

}
