import java.time.LocalDateTime;

public interface FinancialObjectFactory {
    Account createAccount(String name, AccountType type);
    Transaction createTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp);
    Budget createBudget(String name, double amount, LocalDateTime start, LocalDateTime end);
}
