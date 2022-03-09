import java.util.ArrayList;

public class DataReconciliation {

    ArrayList<String> errorsReport = new ArrayList<>();
    ArrayList<Yearly> yearlyBase;
    ArrayList<Monthly> monthlyBase;
    {
        yearlyBase = InformationDatabase.yearlyBase;
        monthlyBase = InformationDatabase.monthlyBase;
    }

    void dataReconciliationMonth() {
        for (Yearly yearly : yearlyBase) {
            int sumAmountMonth = 0;
            for (Monthly monthly : monthlyBase) {
                if ((monthly.month
                        == yearly.monthInYear)
                        && (monthly.is_expense
                        == yearly.is_expenseInYear)) {
                    sumAmountMonth += (monthly.quantity
                            * monthly.sum_of_one);
                }
            }
            if (yearly.amount != sumAmountMonth) {
                String sellPay;
                if (yearly.is_expenseInYear) {
                    sellPay = "spending";
                } else {
                    sellPay = "income";
                }
                errorsReport.add("Месяц " + yearly.monthInYear
                        + ", статья " + sellPay);
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
