import java.util.ArrayList;

public class YearlyReports {
   ArrayList<Yearly> maxYearlyReports;
    {
        maxYearlyReports = InformationDatabase.yearlyBase;
    }

    void printYearlyReports(){
        System.out.println("Отчёт за " + maxYearlyReports.get(0).year + " год");
        profitPerMonth();
        averageConsumption();
        averageIncome();
    }

    //Прибыль помесячно
    void profitPerMonth() {
        if (!maxYearlyReports.isEmpty()) {
            for (int i = 1; i<=12; i++) {
                int maxProfitChek = 0;
                int maxWasteOfMoneyChek = 0;
                for (Yearly maxYearlyReport : maxYearlyReports) {
                    if (maxYearlyReport.monthInYear == i) {
                        if (!maxYearlyReport.is_expenseInYear) {
                            maxProfitChek = maxYearlyReport.amount;
                        } else {
                            maxWasteOfMoneyChek = maxYearlyReport.amount;
                        }
                    }
                }
                if (maxProfitChek >0) {
                    System.out.println("В " + i + " месяце прибыль составила "
                            + (maxProfitChek - maxWasteOfMoneyChek) + "$");
                }
            }
        }
    }

    //Средний расход за все месяцы в году
    void averageConsumption(){
        if (!maxYearlyReports.isEmpty()) {
            int averageWasteOfMoneyChek = 0;
            int counter = 0;
            for (Yearly maxYearlyReport : maxYearlyReports) {
                if (maxYearlyReport.is_expenseInYear) {
                    averageWasteOfMoneyChek += maxYearlyReport.amount;
                    counter++;
                }
            }
            if (averageWasteOfMoneyChek >0) {
                System.out.println("Средний расход за все месяцы в году составляет "
                        + (averageWasteOfMoneyChek / counter) + "$");
            }
        }
    }

    //Средний доход за все месяцы в году
    void averageIncome(){
        if (!maxYearlyReports.isEmpty()) {
            int averageIncomeChek = 0;
            int counter = 0;
            for (Yearly maxYearlyReport : maxYearlyReports) {
                if (!maxYearlyReport.is_expenseInYear) {
                    averageIncomeChek += maxYearlyReport.amount;
                    counter++;
                }
            }
            if (averageIncomeChek >0) {
                System.out.println("Средний доход за все месяцы в году составляет "
                        + (averageIncomeChek / counter) + "$");
            }
        }
    }
}
