package lt.ehu.student.moneytrackerbeta.service;

public interface TransactionService {
    void addTransaction(String category, String type, double amount, String date);
    void deleteTransaction(int transactionId);
    void updateTransaction(int transactionId, String category, String type, double amount, String date);
    double calculateTotalIncome();
    double calculateTotalExpenses();
    double calculateBalance();
    double calculateIncomeByCategory(String category);
    double calculateExpensesByCategory(String category);
    double calculateBalanceByCategory(String category);
    double calculateIncomeByDate(String date);
    double calculateExpensesByDate(String date);
    double calculateBalanceByDate(String date);
}
