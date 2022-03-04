public class YearlyReport {
    int year;
    int monthInYear;
    int amount;
    boolean is_expenseInYear;

    YearlyReport(int year, int monthInYear, int amount,boolean is_expenseInYear) {
        this.year = year;
        this.monthInYear = monthInYear;
        this.amount = amount;
        this.is_expenseInYear = is_expenseInYear;
    }

    int getMonthInYear(){
        return monthInYear;
    }
}
