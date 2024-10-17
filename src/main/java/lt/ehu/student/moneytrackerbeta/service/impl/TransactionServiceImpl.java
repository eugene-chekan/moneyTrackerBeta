package lt.ehu.student.moneytrackerbeta.service.impl;

import lt.ehu.student.moneytrackerbeta.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void addTransaction(String category, String type, double amount, String date) {

    }

    @Override
    public void deleteTransaction(int transactionId) {

    }

    @Override
    public void updateTransaction(int transactionId, String category, String type, double amount, String date) {

    }

    @Override
    public double calculateTotalIncome() {
        return 0;
    }

    @Override
    public double calculateTotalExpenses() {
        return 0;
    }

    @Override
    public double calculateBalance() {
        return 0;
    }

    @Override
    public double calculateIncomeByCategory(String category) {
        return 0;
    }

    @Override
    public double calculateExpensesByCategory(String category) {
        return 0;
    }

    @Override
    public double calculateBalanceByCategory(String category) {
        return 0;
    }

    @Override
    public double calculateIncomeByDate(String date) {
        return 0;
    }

    @Override
    public double calculateExpensesByDate(String date) {
        return 0;
    }

    @Override
    public double calculateBalanceByDate(String date) {
        return 0;
    }
}
