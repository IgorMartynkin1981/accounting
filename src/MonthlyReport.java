import java.util.ArrayList;

public class MonthlyReport {
    int month;
    String itemName;
    boolean is_expense;
    int quantity;
    int sum_of_one;

    InformationDatabase informationDatabase = new InformationDatabase();

    MonthlyReport(int month, String itemName, boolean is_expense, int quantity, int sum_of_one) {
        this.month = month;
        this.itemName = itemName;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    void maxPofit(){
        ArrayList<MonthlyReport> maxProfitBase = informationDatabase.monthlyReports;
        int maxProfitChek = 0;
        if (!maxProfitBase.isEmpty()) {

            for (int i = 0; i< maxProfitBase.size(); i++){


            }
        }

    }
}
