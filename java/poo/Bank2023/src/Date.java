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
