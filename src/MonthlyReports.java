import java.util.ArrayList;

public class MonthlyReports {
    ArrayList<Monthly> maxMonthlyReports;
    {
        maxMonthlyReports = InformationDatabase.monthlyBase;
    }

    void printMaxMonthlyReports(){
        maxPofit();
        maxWasteOfMoney();
    }
    //Самый прибыльный товар
    void maxPofit(){
        if (!maxMonthlyReports.isEmpty()) {
            for (int i = 1; i<=12; i++) {
                int maxProfitChek = 0;
                String maxProfitName = "";
                for (Monthly maxMonthlyReport : maxMonthlyReports) {
                    int sumChek = maxMonthlyReport.sum_of_one * maxMonthlyReport.quantity;
                    if (!maxMonthlyReport.is_expense)
                        if ((i == maxMonthlyReport.month) && (sumChek > maxProfitChek)) {
                            maxProfitChek = sumChek;
                            maxProfitName = maxMonthlyReport.itemName;
                        }
                }
                if (maxProfitChek > 0) {
                    System.out.println("В " + i + " месяце самый прибыльный товар '" + maxProfitName
                            + "', он продан на сумму " + maxProfitChek + "$");
                }
            }
        }

    }

    //Самая большая трата
    void maxWasteOfMoney(){
        if (!maxMonthlyReports.isEmpty()) {
            for (int i = 1; i<=12; i++) {
                int maxWasteOfMoneyChek = 0;
                String maxWasteOfMoneyName = "";
                for (Monthly maxMonthlyReport : maxMonthlyReports) {
                    int sumChek = maxMonthlyReport.sum_of_one * maxMonthlyReport.quantity;
                    if ((i == maxMonthlyReport.month) && (maxMonthlyReport.is_expense)
                            && (sumChek > maxWasteOfMoneyChek)) {
                        maxWasteOfMoneyChek = sumChek;
                        maxWasteOfMoneyName = maxMonthlyReport.itemName;
                    }
                }
                if (maxWasteOfMoneyChek > 0) {
                    System.out.println("В " + i + " месяце самая большая трата была на '" + maxWasteOfMoneyName
                            + "', потрачена сумма " + maxWasteOfMoneyChek + "$");
                }
            }
        }

    }
}
