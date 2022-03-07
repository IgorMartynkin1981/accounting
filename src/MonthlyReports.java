import java.util.ArrayList;

public class MonthlyReports {
    InformationDatabase informationDatabase = new InformationDatabase();
    ArrayList<Monthly> maxMonthlyReports = informationDatabase.monthlyBase;

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
                for (int j = 0; j < maxMonthlyReports.size(); j++) {
                    int sumChek = maxMonthlyReports.get(j).sum_of_one * maxMonthlyReports.get(j).quantity;
                    if ((i == maxMonthlyReports.get(j).month)&&(maxMonthlyReports.get(j).is_expense == false)
                            &&(sumChek > maxProfitChek)){
                        maxProfitChek = sumChek;
                        maxProfitName = maxMonthlyReports.get(j).itemName;
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
                for (int j = 0; j < maxMonthlyReports.size(); j++) {
                    int sumChek = maxMonthlyReports.get(j).sum_of_one * maxMonthlyReports.get(j).quantity;
                    if ((i == maxMonthlyReports.get(j).month)&&(maxMonthlyReports.get(j).is_expense == true)
                            &&(sumChek > maxWasteOfMoneyChek)){
                        maxWasteOfMoneyChek = sumChek;
                        maxWasteOfMoneyName = maxMonthlyReports.get(j).itemName;
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
