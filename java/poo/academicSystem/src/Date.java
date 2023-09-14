public class Date {

    private final int day;
    private final int month;
    private final int year;

//    ===========================================================

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

//    ===========================================================

    private int getDay() {
        return day;
    }

    private int getMonth() {
        return month;
    }

    private int getYear() {
        return year;
    }


//    ===========================================================

    public boolean later(Date d2) {
        if (this.getYear() > d2.getYear()) {
            return true;
        } else if (this.getYear() == d2.getYear() && this.getMonth() > d2.getMonth()) {
            return true;
        } else return this.getYear() == d2.getYear() && this.getMonth() == d2.getMonth() && this.getDay() > d2.getDay();
    }

}
