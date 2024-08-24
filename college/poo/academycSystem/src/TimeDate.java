public class TimeDate {

    private final int day;
    private final int month;
    private final int year;

//    ===========================================================

    public TimeDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

//    ===========================================================

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


//    ===========================================================

    public boolean later(TimeDate d2) {
        if (this.getYear() > d2.getYear()) {
            return true;
        } else if (this.getYear() == d2.getYear() && this.getMonth() > d2.getMonth()) {
            return true;
        } else return this.getYear() == d2.getYear() && this.getMonth() == d2.getMonth() && this.getDay() > d2.getDay();
    }

}
