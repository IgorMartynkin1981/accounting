import java.util.Scanner;

public class CommandLineManager {

    Scanner scanner = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    DataReconciliation dataReconciliation = new DataReconciliation();
    InformationDatabase informationDatabase = new InformationDatabase();

    public void printMenuAndHandleCommand() {
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                fileManager.readAndWriteFileContentMonth();
            } else if (command == 2) {
                fileManager.readAndWriteFileContentYear();
            } else if (command == 3) {
                if (informationDatabase.monthlyReports.isEmpty() || informationDatabase.yearlyReports.isEmpty()){
                    System.out.println("Загрузите данные");
                } else {
                    dataReconciliation.dataReconciliationMonth();
                }
            } else if (command == 4) {
                System.out.println("Вывести информацию о всех месячных отчётах");
            } else if (command == 5) {
                System.out.println("Вывести информацию о годовом отчёте");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}
