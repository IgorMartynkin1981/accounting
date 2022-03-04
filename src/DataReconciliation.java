import java.util.ArrayList;

public class DataReconciliation {

    InformationDatabase informationDatabase = new InformationDatabase();
    ArrayList<String> errorsReport = new ArrayList<>();

    void dataReconciliationMonth() {
        for (int i = 0; i < informationDatabase.yearlyReports.size(); i++) {
            int sumAmountMonth = 0;
            for (int j = 0; j < informationDatabase.monthlyReports.size(); j++) {
                if ((informationDatabase.monthlyReports.get(j).month
                        == informationDatabase.yearlyReports.get(i).monthInYear)
                    &&(informationDatabase.monthlyReports.get(j).is_expense
                        == informationDatabase.yearlyReports.get(i).is_expenseInYear)){
                    sumAmountMonth += (informationDatabase.monthlyReports.get(j).quantity
                            * informationDatabase.monthlyReports.get(j).sum_of_one);
                }
            }
            if (informationDatabase.yearlyReports.get(i).amount != sumAmountMonth) {
                String sellPay;
                if (informationDatabase.yearlyReports.get(i).is_expenseInYear == true) {
                    sellPay = "spending";
                } else {
                    sellPay = "income";
                }
                errorsReport.add("Месяц " + informationDatabase.yearlyReports.get(i).monthInYear
                        + ", статья " +  sellPay);
            }
        }
        if (errorsReport.isEmpty()){
            System.out.println("Все данные верны");
        } else {
            System.out.println("В отчёте есть ошибки. Проверьте данные за:");
            for (String errorMonth : errorsReport) System.out.println(errorMonth);
        }
    }
}
