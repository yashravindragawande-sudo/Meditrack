package interfaces;



public interface Payable {

    double calculateBill(double amount);

    default void printReceipt() {
        System.out.println("Payment completed");
    }
}