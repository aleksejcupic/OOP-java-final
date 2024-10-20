import java.time.LocalDateTime;

public class BankFactory implements FinancialObjectFactory {
    @Override
    public Account createAccount(String name, AccountType type) {
        return new BankAccount(name, type);
    }

    @Override
    public Transaction createTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp) {
        return new BankTransaction(description, type, amount, timestamp);
    }

    @Override
    public Budget createBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        return new BankBudget(name, amount, start, end);
    }
}