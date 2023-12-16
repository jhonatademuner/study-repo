import java.util.ArrayList;
import java.util.List;

public class Exam extends Evaluation {

    private int QuestionsNum;
    private List<StudentExam> grades;

//    ===========================================================

    public Exam(String name, TimeDate applicationDate, double value, int questionsNum, ArrayList<StudentExam> grades) {
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

    public List<StudentExam> getGrades() {
        return this.grades;
    }

    public void setGrades(List<StudentExam> grades) {
        this.grades = grades;
    }

//    ===========================================================

    public double grade(int index) {
        try {
            return this.grades.get(index).totalGrades();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return -1;
    }

    public void swapEvaluation(int i, int j) {
        StudentExam temp = grades.get(i);
        grades.set(i, grades.get(j));
        grades.set(j, temp);
    }

}
