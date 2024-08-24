import java.util.Scanner;

public class Date {
    private int month;
    private int day;
    private int year;

    public Date(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the month: ");
        this.setMonth(input.nextInt());

        System.out.println("Enter the day: ");
        this.setDay(input.nextInt());

        System.out.println("Enter the year: ");
        this.setYear(input.nextInt());
    }

    Date (int m, int d, int y){
        this.setMonth(m);
        this.setDay(d);
        this.setYear(y);
    }

    void print(){
        System.out.println(this.getMonth() + "/" + this.getDay() + "/" + this.getYear());
    }

    boolean later(Date d){
        if (this.getYear() > d.getYear()){
            return true;
        }
        if (this.getYear() == d.getYear() && this.getMonth() > d.getMonth()){
            return true;
        }
        return this.getYear() == d.getYear() && this.getMonth() == d.getMonth() && this.getDay() > d.getDay();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
