package bank2019;

public class Date {
    int month, day, year;

    Date (int m, int d, int y){
        this.month = m;
        this.day = d;
        this.year = y;
    }

    void print(){
        System.out.println(this.month + "/" + this.day + "/" + this.year);
    }
}
