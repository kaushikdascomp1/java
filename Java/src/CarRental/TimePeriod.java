package CarRental;

public class TimePeriod {
    int time;
    int day;
    int month;

    public TimePeriod(int time, int day, int month, int year){
        this.time=time;
        this.day = day;
        this.month=month;
        this.year=year;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    int year;

}
