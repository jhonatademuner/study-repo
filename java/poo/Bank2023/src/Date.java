
import java.util.Scanner;

public class Date {
    int month, day, year;

    public Date(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the month: ");
        this.month = input.nextInt();

        System.out.println("Enter the day: ");
        this.day = input.nextInt();

        System.out.println("Enter the year: ");
        this.year = input.nextInt();
    }

    Date (int m, int d, int y){
        this.month = m;
        this.day = d;
        this.year = y;
    }

    void print(){
        System.out.println(this.month + "/" + this.day + "/" + this.year);
    }

    boolean later(Date d){
        if (this.year > d.year){
            return true;
        }
        if (this.year == d.year && this.month > d.month){
            return true;
        }
        return this.year == d.year && this.month == d.month && this.day > d.day;
    }
}
