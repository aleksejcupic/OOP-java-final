import java.time.LocalDateTime;

public class CreditCardFactory implements FinancialObjectFactory {
    @Override
    public Account createAccount(String name, AccountType type) {
        return new CreditCardAccount(name, type);
    }

    @Override
    public Transaction createTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp) {
        return new CreditCardTransaction(description, type, amount, timestamp);
    }

    @Override
    public Budget createBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        return new CreditCardBudget(name, amount, start, end);
    }
}
