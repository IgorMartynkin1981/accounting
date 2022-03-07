import java.util.ArrayList;

public class DataReconciliation {

    InformationDatabase informationDatabase = new InformationDatabase();
    ArrayList<String> errorsReport = new ArrayList<>();

    void dataReconciliationMonth() {
        for (int i = 0; i < informationDatabase.yearlyBase.size(); i++) {
            int sumAmountMonth = 0;
            for (int j = 0; j < informationDatabase.monthlyBase.size(); j++) {
                if ((informationDatabase.monthlyBase.get(j).month
                        == informationDatabase.yearlyBase.get(i).monthInYear)
                    &&(informationDatabase.monthlyBase.get(j).is_expense
                        == informationDatabase.yearlyBase.get(i).is_expenseInYear)){
                    sumAmountMonth += (informationDatabase.monthlyBase.get(j).quantity
                            * informationDatabase.monthlyBase.get(j).sum_of_one);
                }
            }
            if (informationDatabase.yearlyBase.get(i).amount != sumAmountMonth) {
                String sellPay;
                if (informationDatabase.yearlyBase.get(i).is_expenseInYear == true) {
                    sellPay = "spending";
                } else {
                    sellPay = "income";
                }
                errorsReport.add("Месяц " + informationDatabase.yearlyBase.get(i).monthInYear
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
