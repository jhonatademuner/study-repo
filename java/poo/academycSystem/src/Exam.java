public class Exam extends Evaluation {

    private int QuestionsNum;
    private StudentExam[] grades;

//    ===========================================================

    public Exam(String name, TimeDate applicationDate, double value, int questionsNum, StudentExam[] grades) {
        super(name, applicationDate, value);
        this.QuestionsNum = questionsNum;
        this.grades = grades;
    }

//    ===========================================================

    public int getQuestionsNum() {
        return this.QuestionsNum;
    }

    public void setQuestionsNum(int questionsNum) {
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
        try {
            return this.grades[index].totalGrades();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return -1;
    }

}
