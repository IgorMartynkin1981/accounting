public class Monthly {
    int month;
    String itemName;
    boolean is_expense;
    int quantity;
    int sum_of_one;

    Monthly(int month, String itemName, boolean is_expense, int quantity, int sum_of_one) {
        this.month = month;
        this.itemName = itemName;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
}
